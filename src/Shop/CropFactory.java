package Shop;

import java.util.HashMap;

public class CropFactory extends AbstractFactory {
    @Override
    public Fertilizer getFertilizer(String fertilierType){
        return null;
    }

    //declare a hashmap to store entity classses
    private static HashMap<String,Crop> cropMap = new HashMap<>();

    //new crops and store them in the cropmap
    public CropFactory(){
        cropMap.put("Tomato",new Tomato());
        cropMap.put("Potato",new Potato());
        cropMap.put("Cabbage",new Cabbage());
    }

    @Override
    public Crop getCrop(String cropType) {
        if(cropType == null){
            return null;
        }
        if(cropType.equalsIgnoreCase("TOMATO")){
            return (Crop)cropMap.get("Tomato").clone();
        } else if(cropType.equalsIgnoreCase("POTATO")){
            return (Crop)cropMap.get("Potato").clone();
        } else if(cropType.equalsIgnoreCase("CABBAGE")){
            return (Crop)cropMap.get("Cabbage").clone();
        }
        return null;
    }
}
