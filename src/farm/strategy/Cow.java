package farm.strategy;

/*
 * This is a cow.
 */
public class Cow extends Animal {
    public Cow(){
        sound=new CowSound();
        strength=500;
    }
    /*
     * Feed cows
     */
    @Override
    public void feed() {
        feed.feedAnimal("Cows");
    }
}
