import memento.CareTaker;
import memento.Originator;
import transferObject.AnimalBO;
import transferObject.AnimalVO;

public class mementoAndTransferObjectTest {
    public static void mementoAndTransferObjectTest(){
        //test transfer object pattern and memento pattern
        //new memento
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        System.out.println("\n------Transfer Object Pattern------\n");
        AnimalBO animalBusinessObject = new AnimalBO();
        //Output all animals in database
        System.out.println("Output all animals in database:");
        for (AnimalVO i : animalBusinessObject.getAllAnimals()) {
            System.out.println("[animal:" + i.getKind() + ", Total : " + i.getTotal() + " ]");
        }
        System.out.println("\n------Memento Pattern------\n");
        AnimalVO animal = animalBusinessObject.getAnimal("Cow");
        //Store first state
        originator.setState(new AnimalVO(animal));
        careTaker.add(originator.saveStateToMemento());
        //Update the number of animals
        System.out.println("Update the number of animals:");
        animal.setTotal(20);
        animalBusinessObject.updateAnimal(animal);
        //Store the second state
        originator.setState(new AnimalVO(animal));
        careTaker.add(originator.saveStateToMemento());
        //Get animals
        animalBusinessObject.getAnimal("Cow");
        System.out.println("[animal:" + animal.getKind() + ", Total : " + animal.getTotal() + " ]");
        //Return to the original state
        System.out.println("Return to the original state:");
        originator.getStateFromMemento(careTaker.get(0));
        animal = (AnimalVO) originator.getState();
        System.out.println("[animal:" + animal.getKind() + ", Total : " + animal.getTotal() + " ]");
    }
}
