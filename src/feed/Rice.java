package feed;

/**
 * Rice feed
 *
 * @author RootReturn0
 * @Time 2019-10-25
 */
public class Rice implements FeedAPI {
    /**
     * Feed animal with rice
     *
     * @param animal: the animal to be fed
     */
    @Override
    public void feedAnimal(String animal) {
        System.out.println("Rice | " + animal + " are fed by rice!");
    }
}
