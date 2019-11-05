package farm.strategy;

/*
 * Strategy Pattern
 * Simulate donkey sound.
 */
public class DonkeySound implements Sound{
    @Override
    public void makeSound() {
        System.out.println("I'm a donkey...Bray,bray!");
    }
}
