package Decorator.farmers;

import farm.Farmer;

public class WateringPotDecorator extends BaseFarmerDecorator{
    public WateringPotDecorator(Farmer farmer){
        super(farmer);
    }
    //show that an animal is decorated with a watering pot and others
    public void showDecoration()
    {
        System.out.println("Decorated with：Watering Pot");
        farmer.showDecoration();
    }
    //call this method of a decorated farmer so you can use the tool
    public void doWateringPot(){
        System.out.println("I am watering..");
    }
}
