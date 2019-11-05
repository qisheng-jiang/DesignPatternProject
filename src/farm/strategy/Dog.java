package farm.strategy;

/*
 * This is a dog.
 */
public class Dog extends Animal {
    public Dog(){
        sound=new DogSound();
        strength=100;
    }
    /*
     * Feed dogs
     */
    @Override
    public void feed() {
        feed.feedAnimal("Dogs");
    }
}
