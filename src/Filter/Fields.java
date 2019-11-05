package Filter;

import Shop.AbstractFactory;
import Shop.Crop;
import Shop.Fertilizer;
import Shop.Shop;
import Weather.WeatherToday;

import java.util.ArrayList;

public class Fields {
    public static ArrayList<Field> fields;
    public Fields(){
        fields=new ArrayList<Field>();
        Integer i=0;
        //Initial 6 new lands
        while(i<6) {
            fields.add(new Field(++i));
        }
    }
    public Fields(int size){
        fields=new ArrayList<Field>();
        Integer i=0;
        //Initial size new lands
        while(i<size) {
            fields.add(new Field(++i));
        }
    }

    //Show land status
    public void showDetail(){
        System.out.println("You have "+fields.size()+ " pieces of land, No. 1-"+fields.size());
        System.out.println("The numbers of the senior fields are:");
        Criteria advanced =new CriteriaAdvanced();
        for(Field f:advanced.meetCriteria(fields)){
            System.out.println(f.getId());
        }
        System.out.println("The numbers of the unplanted fields are:");
        Criteria unplanted =new CriteriaUnplanted();
        for(Field f:unplanted.meetCriteria(fields)){
            System.out.println(f.getId());
        }
        System.out.println("The numbers of the harvested fields are:");
        Criteria unRipeField = new CriteriaRipe();
        Criteria plantedField = new CriteriaPlanted();
        Criteria availableField = new AndCriteria(unRipeField, plantedField);
        for(Field f:availableField.meetCriteria(fields)){
            System.out.println(f.getId());
        }
    }

    //Planting land, parameter k is the total number of seeds
    public boolean plant(String c,Integer k){

        //Determine if the crop exists
        AbstractFactory cropFactory = Shop.getFactory("CROP");

        Crop crop = cropFactory.getCrop(c);

        if(crop==null){
            System.out.println("There are not this kind of crop!");
            return false;
        }

        //Screening out uncultivated land
        Criteria unPlanted = new CriteriaUnplanted();
        if(k<=unPlanted.meetCriteria(fields).size()){
            for(Field f:unPlanted.meetCriteria(fields)){
                if(k>0&&f.plant(crop)){
                    k--;
                }
                else break;
            }
            System.out.println("Crops has been planted Successfully!");
        }
        else{
            System.out.println("There are not enough fields!");
            return false;
        }
        return true;
    }
    //Land fertilization K is the land number
    public boolean applyFertilizer(String t,Integer k){
        //Check for the presence of this fertilizer
        AbstractFactory fertilizerFactory = Shop.getFactory("FERTILIZER");

        Fertilizer fer = fertilizerFactory.getFertilizer(t);

        if(fer==null){
            System.out.println("There are not this kind of fertilizer!");
            return false;
        }
        //Selected immature land
        boolean isAllowed=false;
        Criteria unRipeField = new CriteriaUnRipe();
        Criteria plantedField = new CriteriaPlanted();
        Criteria availableField = new AndCriteria(unRipeField, plantedField);
        for(Field f:availableField.meetCriteria(fields)){
            if(f.getId()==k&&f.checkIsF()==false){
                isAllowed=true;
                if(f.applyFertilizer(fer)){
                    System.out.println("Fertilize Successfully!");
                }
                break;
            }
        }
        if(isAllowed==false){
            System.out.println("Please choose the available field!");
            return false;
        }
        return true;
    }
    //Harvest fruit
    public boolean harvest(Integer k){
        //Screen out all the land that can be harvested
        boolean isAllowed=false;
        Criteria ripeField = new CriteriaRipe();
        Criteria plantedField = new CriteriaPlanted();
        Criteria havestedField = new AndCriteria(ripeField, plantedField);
        for(Field f:havestedField.meetCriteria(fields)){
            if(f.getId()==k){
                isAllowed=true;
                f.doHarvest();
                System.out.println("Harvest successfully!");
                break;
            }
        }
        if(isAllowed==false){
            System.out.println("Please choose the available field!");
            return false;
        }
        return true;
    }
    //One click for all
    public boolean harvestAll(){
        //Screen out all the land that can be harvested
        Criteria ripeField = new CriteriaRipe();
        Criteria plantedField = new CriteriaPlanted();
        Criteria havestedField = new AndCriteria(ripeField, plantedField);
        if(havestedField.meetCriteria(fields).size()>0){
            for(Field f:havestedField.meetCriteria(fields)){
                f.doHarvest();
            }
            System.out.println("Harvest successfully!");
            return true;
        }
        else{
            System.out.println("There isn't available field!");
            return false;
        }
    }
    //Upgrade land
    public void updateField(Integer k){
        if(Shop.fund<10000){
            System.out.println("Insufficient funds!");
        }
        else{
            boolean isAllowed=false;
            Criteria unUpdatedField = new CriteriaUnAdvanced();
            for(Field f:unUpdatedField.meetCriteria(fields)){
                if(f.getId()==k){
                    isAllowed=true;
                    f.update();
                    Shop.fund=Shop.fund-10000;
                    System.out.println("Update Successfully!");
                    break;
                }
            }
            if(isAllowed==false){
                System.out.println("Please choose the available field!");
            }
        }
    }
}
