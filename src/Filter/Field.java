package Filter;

import Shop.Crop;
import Shop.Fertilizer;
import State.*;
import Visitor.FieldVisitor;
import WH.Warehouse;
import Weather.Observer;
import Weather.WeatherToday;


import java.util.Timer;
import java.util.TimerTask;


public class Field extends Observer {
    private int moisture;
    private Integer id;
    private String planted;
    private boolean isUpdate;
    private Integer timeRemains;
    private Integer harvest;
    private boolean isFertilizer;
    private State fieldState;
    //Build countdown
    public class CountTime{
        public CountTime(){
            Timer t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    timeRemains--;
                    if(timeRemains==0){
                        fieldState=StateCollection.getState("RIPE");
                        fieldState.showState(id);
                        t.cancel();
                    }
                }
            },0,1000);
        }
    }
    public Field(Integer num){
        moisture=60;
        id=num;
        planted=null;
        isUpdate=false;
        timeRemains=-1;
        harvest=0;
        isFertilizer=false;
        fieldState=StateCollection.getState("UNPLANTED");
    }

    //raise crops
    public boolean plant(Crop c){

        planted=c.getName();
        harvest=c.getYield();
        if(isUpdate==true){
            timeRemains=c.getGrowTime()*4/5;
        }
        else {
            timeRemains = c.getGrowTime();
        }
        new CountTime();
        fieldState=StateCollection.getState("GROWING");
        fieldState.showState(id);
        return true;
    }
    //Apply fertilizer
    public boolean applyFertilizer(Fertilizer type){

        //Generate keywords
        String key=type.getName();
        //Optimized planting
        if(optimizeByF(key)){
            isFertilizer=true;
            return true;
        }
        else{
            return false;
        }
    }

    //Harvest crops
    public void doHarvest(){
        //Get warehouse object
        Warehouse w= Warehouse.getInstance();
        //Warehousing
        w.addItem(planted,harvest);
        w.addProduct(planted);
        //Change state
        fieldState=StateCollection.getState("UNPLANTED");
        fieldState.showState(id);
        //Initialize field
        planted=null;
        timeRemains=-1;
        harvest=0;
        isFertilizer=false;
    }
    //Upgrade land
    public void update(){
        isUpdate=true;
    }
    //Fertilizer optimization
    public boolean optimizeByF(String type){
        if(type=="NormalF"){
            timeRemains=timeRemains*4/5;
        }
        else if(type=="AdvancedF"){
            timeRemains=timeRemains*2/3;
        }
        else if(type=="SuperF"){
            timeRemains=timeRemains/2;
            harvest=harvest*4/3;
        }
        else {
            System.out.println("Parameter error!");
            return false;
        }
        return true;
    }
    public boolean checkUpdated(){
        return isUpdate;
    }
    public String checkCrop(){
        return planted;
    }
    public Integer checkTime(){
        return timeRemains;
    }
    public boolean checkIsF(){return isFertilizer;}
    public Integer getId(){return id;}

    //Renew soil moisture
    public void updateMoisture(String weather){
        if(weather.equalsIgnoreCase("rainy")){
            this.moisture+=2;
            System.out.println("The moisture of field "+this.id+" is "+this.moisture);
        }
    }

    public int getMoisture() {
        return moisture;
    }

    public void accept(FieldVisitor fieldVisitor){
        fieldVisitor.visit(this);
    }
}
