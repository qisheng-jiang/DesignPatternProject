package Shop;

import java.util.HashMap;

public class FertilizerFactory extends AbstractFactory {

    //declare a hashmap store fertilizer object
    private static final HashMap<String, Fertilizer> fertilizerMap = new HashMap<>();

    //get fertilizer object from fertilizerMap
    @Override
    public Fertilizer getFertilizer(String fertilizerType){

        if(fertilizerType == null){
            return null;
        }

        //if feitilizermap doesn't have this type,new and put it in the map
        Fertilizer fertilizer =fertilizerMap.get(fertilizerType.toUpperCase());

        if(fertilizer==null){
            if(fertilizerType.equalsIgnoreCase("NormalF")){
                fertilizer = new NormalF();
                fertilizerMap.put("NORMALF",fertilizer);
            } else if(fertilizerType.equalsIgnoreCase("AdvancedF")){
                fertilizer = new AdvancedF();
                fertilizerMap.put("ADVANCEDF",fertilizer);
            } else if(fertilizerType.equalsIgnoreCase("SuperF")) {
                fertilizer = new SuperF();
                fertilizerMap.put("SUPERF", fertilizer);
            }else {
                return null;
            }
        }
        return fertilizer;
    }
    @Override
    public Crop getCrop(String crop){
        return null;
    }
}
