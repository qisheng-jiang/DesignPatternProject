package farm.strategy;

/*
 * Strategy Pattern
 * Simulate cat sound.
 */
public class CatSound implements Sound{
    @Override
    public void makeSound() {
        System.out.println("I'm a cat...Mew,mew!");
    }
}
