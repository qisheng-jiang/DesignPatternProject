package farm.strategy;

/*
 * Strategy Pattern
 * Simulate dog sound.
 */
public class DogSound implements Sound {
    @Override
    public void makeSound() {
        System.out.println("I'm a dog...Auf,auf!");
    }
}
