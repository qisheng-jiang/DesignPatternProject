package Shop;

import PurchaseHistory.PurchaseHistory;

import java.util.ArrayList;
import java.util.Arrays;

public class Shop {
    public static Integer fund=10000;

    //初始化作物商品列表
    public static ArrayList<String> cropCatalogue = new ArrayList<String>(Arrays.asList("Cabbage","Potato","Tomato"));

    //初始化肥料商品列表
    public static ArrayList<String> fertilizerCatalogue = new ArrayList<String>(Arrays.asList("NormalF","AdvancedF","SuperF"));

    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("FERTILIZER")){
            return new FertilizerFactory();
        } else if(choice.equalsIgnoreCase("CROP")){
            return new CropFactory();
        }
        return null;
    }

    public static void showCatalogue(){

        AbstractFactory cropFactory = Shop.getFactory("CROP");
        AbstractFactory fertilizerFactory = Shop.getFactory("FERTILIZER");
        System.out.println("Crop:");
        for(String crop:cropCatalogue){
            Crop c = cropFactory.getCrop(crop);
            System.out.println("Name:"+c.getName()+"   Price:"+c.getCost());
        }
        System.out.println("Fertilizer:");
        for(String fertilizer:fertilizerCatalogue){
            Fertilizer f = fertilizerFactory.getFertilizer(fertilizer);
            System.out.println("Name:"+f.getName()+"   Price:"+f.getPrice());
        }
    }

    public static boolean purchase(String name,Integer num){

        AbstractFactory cropFactory = Shop.getFactory("CROP");
        AbstractFactory fertilizerFactory = Shop.getFactory("FERTILIZER");
        Crop c = cropFactory.getCrop(name);
        Fertilizer f = fertilizerFactory.getFertilizer(name);
        if(c!=null){
            if(c.purchase(num)){
                return true;
            }
            else{
                return false;
            }
        }
        if(f!=null){
            if(f.purchase(num)){
                return true;
            }
            else{
                return false;
            }
        }
        System.out.println("We don't have this kind of product!");
        return false;
    }
}
