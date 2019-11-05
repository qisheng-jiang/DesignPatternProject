package farm.strategy;

import feed.FeedAPI;

/*
 * Template Pattern
 * Base Animal class
 */
public abstract class Animal implements Speaker {
    Sound sound;
    int strength;
    FeedAPI feed; // Object to feed the animal

	//Animal speaks with default sound.
    public void speak() {
        sound.makeSound();
    }

    /*
     * Strategy Pattern
     * With this method, you can let an animal make the sound you want.
     */
    public void speak(Sound s) {
        s.makeSound();
    }

    public int getStrength() {
        return strength;
    }

    public void showDecoration() {
    }


    /*
	 * Bridge Pattern
     * Set the proper API that suits the animal
     */
    public void setFeedAPI(FeedAPI feed) {
        this.feed = feed;
    }

	// Feed the animal
    public void feed(){};
}
