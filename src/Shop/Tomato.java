package Shop;

import WH.Warehouse;

public class Tomato implements Crop,Cloneable{
    private final String name="Tomato";
    private final Integer growTime=10;
    private final Integer cost=150;
    private final Integer yield=40;
    private final Integer unitPrice=30;

    @Override
    public String getName(){return name;}
    public Integer getGrowTime(){
        return growTime;
    }
    public Integer getYield(){return yield;}
    public Integer getPrice(){return unitPrice;}
    public Integer getCost(){return cost;}
    public boolean purchase(Integer num){
        if(num*cost>Shop.fund){
            System.out.println("Insufficient funds, unable to buy!");
            return false;
        }
        else{
            Warehouse w= Warehouse.getInstance();
            w.addItem("TomatoS",num);
            Shop.fund=Shop.fund-num*cost;
            System.out.println("Purchase successfully!");
            return true;
        }
    }

    public Object clone(){
        Object clone =null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
