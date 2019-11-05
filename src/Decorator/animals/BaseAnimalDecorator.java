package Decorator.animals;

import farm.strategy.Animal;

public abstract class BaseAnimalDecorator extends Animal {
    protected Animal animal;//object that's to be decorated.
    // can be object that has been decorated before

    BaseAnimalDecorator(Animal animal){
        this.animal = animal;
    }

}
