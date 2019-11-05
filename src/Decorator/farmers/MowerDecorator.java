package Decorator.farmers;

import farm.Farmer;

public class MowerDecorator extends BaseFarmerDecorator{
    public MowerDecorator(Farmer farmer){
        super(farmer);
    }
    //show that an animal is decorated with a mower and others
    public void showDecoration()
    {
        System.out.println("Decorated with：Mower");
        farmer.showDecoration();
    }
    //call this method of a decorated farmer so you can use the tool

    public void doMower(){
        System.out.println("I am Mowing...");
    }
}