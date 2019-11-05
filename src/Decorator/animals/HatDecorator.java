package Decorator.animals;

import farm.strategy.Animal;

public class HatDecorator extends BaseAnimalDecorator {

    public HatDecorator(Animal animal){
        super(animal);
    }
    //show that an animal is decorated with a hat and others
    public void showDecoration()
    {
        System.out.println("Decorated with：A hat");
        animal.showDecoration();
    }
}
