package Decorator.farmers;

import farm.Farmer;
import farm.strategy.Animal;

public abstract class BaseFarmerDecorator extends Farmer{
    protected Farmer farmer;//object that's to be decorated.
    // can be object that has been decorated before

    BaseFarmerDecorator(Farmer farmer){
        this.farmer = farmer;
    }
    //public abstract void doMower();
}
