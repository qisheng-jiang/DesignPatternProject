package feed;

/**
 * Cereal feed
 *
 * @author RootReturn0
 * @Time 2019-10-25
 */
public class Cereal implements FeedAPI {
    /**
     * Feed animal with cereal
     *
     * @param animal: the animal to be fed
     */
    @Override
    public void feedAnimal(String animal) {
        System.out.println("Cereal | " + animal + " are fed by cereal!");
    }
}
