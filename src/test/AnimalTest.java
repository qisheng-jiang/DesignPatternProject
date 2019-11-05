package test;

import Adapter.Stone;
import Decorator.animals.DomesticQuarantineDecorator;
import Decorator.animals.ExportQuarantineDecorator;
import Decorator.animals.HatDecorator;
import Decorator.animals.TieDecorator;
import Interpreter.AnimalInterpreterPattern;
import Interpreter.IExpression;
import farm.strategy.*;
import feed.Grass;
import memento.CareTaker;
import memento.Originator;
import transferObject.AnimalBO;
import transferObject.AnimalVO;

public class AnimalTest {

    public static void main(String[] args) {
        Stone stone = new Stone(400);

        //test template
        System.out.println("\n------Template Pattern------\n");
        Donkey donkey = new Donkey();
        System.out.println("Initialize a donkey.");
        System.out.println("");

        //test strategy
        System.out.println("\n------Strategy Pattern------\n");
        donkey.speak();
        donkey.speak(new CatSound());
        System.out.println("");


        //test bridge
        System.out.println("\n------Bridge Pattern------\n");
        donkey.setFeedAPI(new Grass());
        donkey.feed();
        System.out.println("");

        //test adapter
        System.out.println("\n------Adapter Pattern------\n");
        stone.move(donkey);
        System.out.println("Stone is moved by Donkey with " + donkey.getStrength() + " force.");
        System.out.println("");

        //test decorator(there is another part for decorator testing in StaffTest.java)
        System.out.println("\n------Decorator Pattern I------\n");
        Animal donkey2 = new Donkey();
        donkey2 = new DomesticQuarantineDecorator(donkey2);
        donkey2 = new HatDecorator(donkey2);
        donkey2.showDecoration();
        System.out.println("");

        //test interpreter pattern
        System.out.println("\n------Interpreter Pattern------\n");
        IExpression isDog = AnimalInterpreterPattern.getDogExpression();
        IExpression isHen = AnimalInterpreterPattern.getHenExpression();
        System.out.println("John is a dog? " + isDog.interpret("John"));
        System.out.println("Julie is a hen? " + isHen.interpret("Hen Julie"));

        //test transfer object pattern and memento pattern
        //new memento
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        System.out.println("\n------Transfer Object Pattern------\n");
        AnimalBO animalBusinessObject = new AnimalBO();
        //Output all animals in database
        for (AnimalVO i : animalBusinessObject.getAllAnimals()) {
            System.out.println("[animal:" + i.getKind() + ", Total : " + i.getTotal() + " ]");
        }
        System.out.println("\n------Memento Pattern------\n");
        AnimalVO animal = animalBusinessObject.getAnimal("Cow");
        //Store first state
        originator.setState(new AnimalVO(animal));
        careTaker.add(originator.saveStateToMemento());
        //Update the number of animals
        animal.setTotal(20);
        animalBusinessObject.updateAnimal(animal);
        //Store the second state
        originator.setState(new AnimalVO(animal));
        careTaker.add(originator.saveStateToMemento());
        //Get animals
        animalBusinessObject.getAnimal("Cow");
        System.out.println("[animal:" + animal.getKind() + ", Total : " + animal.getTotal() + " ]");
        //Return to the original state
        originator.getStateFromMemento(careTaker.get(0));
        animal = (AnimalVO) originator.getState();
        System.out.println("[animal:" + animal.getKind() + ", Total : " + animal.getTotal() + " ]");
    }
}