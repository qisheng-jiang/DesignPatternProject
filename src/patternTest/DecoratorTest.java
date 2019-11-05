package patternTest;

import Decorator.animals.DomesticQuarantineDecorator;
import Decorator.animals.HatDecorator;
import Decorator.farmers.MowerDecorator;
import Decorator.farmers.WateringPotDecorator;
import farm.Farmer;
import farm.strategy.Animal;
import farm.strategy.Donkey;

public class DecoratorTest {
    public static void DecoratorTest() {
        System.out.println("\n------Decorator Pattern ------\n");
        Farmer myFarmer = new Farmer();
        myFarmer = new MowerDecorator(myFarmer);
        myFarmer.doMower();
        myFarmer.doShovel();
        myFarmer = new WateringPotDecorator(myFarmer);
        myFarmer.doWateringPot();
        myFarmer.showDecoration();
        System.out.println("");

        Animal donkey2 = new Donkey();
        donkey2 = new DomesticQuarantineDecorator(donkey2);
        donkey2 = new HatDecorator(donkey2);
        donkey2.showDecoration();
        System.out.println("");
    }
}
