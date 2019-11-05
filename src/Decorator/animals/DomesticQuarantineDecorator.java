package Decorator.animals;

import farm.strategy.Animal;

//Quarantine needed for domestic animal selling
public class DomesticQuarantineDecorator extends BaseAnimalDecorator{
    public DomesticQuarantineDecorator(Animal animal){
        super(animal);
    }

    //show that an animal is decorated with domestic quarantine and others
    public void showDecoration()
    {
        System.out.println("Decorated with：Domestic Quarantine");
        animal.showDecoration();
    }

}