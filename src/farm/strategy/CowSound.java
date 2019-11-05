package farm.strategy;

/*
 * Strategy Pattern
 * Simulate cow sound.
 */
public class CowSound implements Sound{
    @Override
    public void makeSound() {
        System.out.println("I'm a cow..Moo,moo!");
    }
}
