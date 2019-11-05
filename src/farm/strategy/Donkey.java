package farm.strategy;

/*
 * This is a donkey.
 */
public class Donkey extends Animal{
    public Donkey(){
        sound=new DonkeySound();
        strength=400;
    }
    /* 
     * Feed donkeys
     */
    @Override
    public void feed() {
        feed.feedAnimal("Donkeys");
    }
}
