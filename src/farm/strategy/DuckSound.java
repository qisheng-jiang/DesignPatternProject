package farm.strategy;

/*
 * Strategy Pattern
 * Simulate duck sound.
 */
public class DuckSound implements Sound{

    @Override
    public void makeSound() {
        System.out.println("I'm a duck...Quack,quack!");
    }
}
