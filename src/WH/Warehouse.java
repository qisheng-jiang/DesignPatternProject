package WH;

import Shop.AbstractFactory;
import Shop.Crop;
import Shop.Shop;
import memento.Memento;

import java.util.ArrayList;
import java.util.HashMap;

public class Warehouse {

    private static Warehouse instance = new Warehouse();
    //List of products available for sale
    public static ArrayList<String> productList=new ArrayList<String>();
    //Inventory in warehouse and its corresponding quantity
    public static final HashMap<String, Integer> reserveap = new HashMap<>();

    //Make the constructor private so that the class is not instantiated
    private Warehouse(){}

    //Get the only available objects
    public static Warehouse getInstance(){
        return instance;
    }

    //Show all items
    public void showItems(){
        if(reserveap.isEmpty()){
            System.out.println("Your warehouse is empty!");
        }
        else{
            System.out.println("List of goods：");
            for(String key:reserveap.keySet())
            {
                System.out.println("Item: "+key+" Number: "+reserveap.get(key));
            }
        }
    }

    //Add goods
    public void addItem(String kind,Integer num){
        if(num>0&&kind!=null){
            if(reserveap.containsKey(kind)){
                reserveap.put(kind,num+reserveap.get(kind));
            }
            else{
                reserveap.put(kind,num);
            }
            System.out.println("Add successfully！");
        }
        else{
            System.out.println("Parameter error！");
        }
    }

    //Add product list
    public void addProduct(String name){
        if(!productList.contains(name)){
            productList.add(name);
        }
    }

    //Reduce cargo
    public boolean reduceItem(String kind,Integer num){
        if(reserveap.containsKey(kind)){
            Integer stock=reserveap.get(kind);
            //Reduce all
            if(stock==num){
                reserveap.remove(kind);
                if(productList.contains(kind)){
                    productList.remove(kind);
                }
            }
            //Reduce part
            else if(stock>num){
                reserveap.put(kind,reserveap.get(kind)-num);
            }
            //Parameter exceeded
            else{
                System.out.println("We don't have enough stock!");
                return false;
            }
        }
        else{
            System.out.println("Don't have the item!");
            return false;
        }
        return true;
    }
    //Sell goods
    public boolean sellProduct(String kind,Integer num){
        //Convert keywords
        for(String s:productList){
            if(s.equalsIgnoreCase(kind)){
                kind=s;
                break;
            }
        }
        if(reduceItem(kind,num)){
            AbstractFactory cropFactory = Shop.getFactory("CROP");

            Crop c = cropFactory.getCrop(kind);

            if(c==null){
                System.out.println("We don't have this kind of product!");
                return false;
            }
            Shop.fund=Shop.fund+c.getPrice()*num;
            System.out.println("Sell Successfully!");
            return true;
        }
        else{
            return false;
        }
    }

    //Sell all crops
    public boolean sellAll(){
        AbstractFactory cropFactory = Shop.getFactory("CROP");
        //Determine whether there are goods available for sale
        if(productList.isEmpty()){
            System.out.println("We don't have any product to sell!");
            return false;
        }

        //The purpose of this loop is to report an error when changing the array of for in the for loop, so jump out and re traverse
        while(productList.size()>0){
            for(String kind:productList){
                Integer temp=reserveap.get(kind);
                if(reduceItem(kind,temp)){
                    Crop c = cropFactory.getCrop(kind);
                    Shop.fund=Shop.fund+c.getPrice()*temp;
                    break;
                }
            }
        }
        System.out.println("Sold out!");
        return true;
    }

}
