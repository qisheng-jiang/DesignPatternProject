package Shop;

import WH.Warehouse;

public class NormalF implements Fertilizer{
    private final String name="NormalF";
    private final Integer price=200;
    @Override
    public String getName(){return name;}
    public Integer getPrice(){return price;}
    public boolean purchase(Integer num){
        if(num*price>Shop.fund){
            System.out.println("Insufficient funds, unable to buy!");
            return false;
        }
        else{
            Warehouse w= Warehouse.getInstance();
            w.addItem("NormalF",num);
            Shop.fund=Shop.fund-num*price;
            System.out.println("Purchase successfully!");
            return true;
        }
    }
}
