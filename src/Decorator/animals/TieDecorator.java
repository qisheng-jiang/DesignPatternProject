package Decorator.animals;

import farm.strategy.Animal;

public class TieDecorator extends BaseAnimalDecorator {

    public TieDecorator(Animal animal){
        super(animal);
    }
    //show that an animal is decorated with a tie and others
    public void showDecoration()
    {
        System.out.println("Decorated with：A tie");
        animal.showDecoration();
    }

}
