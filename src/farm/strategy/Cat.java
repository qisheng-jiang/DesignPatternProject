package farm.strategy;


/*
 * This is a cat.
 */
public class Cat extends Animal {

    public Cat(){
        sound=new CatSound();
        this.strength=20;
    }
    /*
     * Feed cats
     */
    @Override
    public void feed() {
        feed.feedAnimal("Cats");
    }
}
