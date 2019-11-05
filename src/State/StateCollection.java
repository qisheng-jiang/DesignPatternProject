package State;

public class StateCollection {
    private static State unplantedState=new UnplantedState();
    private static State growingState=new GrowingState();
    private static State ripeState=new RipeState();

    public static State getState(String type){
        if(type.equalsIgnoreCase("UNPLANTED")){
            return unplantedState;
        }
        else if(type.equalsIgnoreCase("GROWING")){
            return growingState;
        }
        else if(type.equalsIgnoreCase("RIPE")){
            return ripeState;
        }
        else{
            System.out.println("Wrong input!");
            return null;
        }

    }

}
