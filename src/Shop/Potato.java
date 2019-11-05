package Shop;

import WH.Warehouse;

public class Potato implements Crop,Cloneable {
    private final String name="Potato";
    private final Integer growTime=30;
    private final Integer cost=200;
    private final Integer yield=50;
    private final Integer unitPrice=20;

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
            w.addItem("PotatoS",num);
            Shop.fund=Shop.fund-num*cost;
            System.out.println("Purchase successfully!");
            return true;
        }
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
