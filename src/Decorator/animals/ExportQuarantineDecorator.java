package Decorator.animals;

import farm.strategy.Animal;

//Quarantine needed for animal selling abroad
public class ExportQuarantineDecorator extends BaseAnimalDecorator{

    public ExportQuarantineDecorator(Animal animal){
        super(animal);
    }
    //show that an animal is decorated with export quarantine and others
    public void showDecoration()
    {
        System.out.println("Decorated with：Export Quarantine");
        animal.showDecoration();
    }
}