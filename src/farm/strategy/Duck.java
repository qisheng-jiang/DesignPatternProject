package farm.strategy;

/*
 * This is a duck.
 */
public class Duck extends Animal {
    public Duck(){
        sound=new DuckSound();
        strength=30;
    }
    /**
     * Feed ducks
     */
    @Override
    public void feed() {
        feed.feedAnimal("Ducks");
    }
}
