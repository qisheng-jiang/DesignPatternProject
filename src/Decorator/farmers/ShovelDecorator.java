package Decorator.farmers;

import farm.Farmer;

public class ShovelDecorator extends BaseFarmerDecorator{


    public ShovelDecorator(Farmer farmer){
        super(farmer);
    }
    //show that an animal is decorated with a shovel and others
    public void showDecoration()
    {
        System.out.println("Decorated with：A Shovel");
        farmer.showDecoration();
    }
    //call this method of a decorated farmer so you can use the tool
    public void doShovel(){
        System.out.println("I am shoveling...");
    }
}