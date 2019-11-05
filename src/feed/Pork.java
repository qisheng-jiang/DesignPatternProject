package feed;

/**
 * Pork feed
 *
 * @author RootReturn0
 * @Time 2019-10-25
 */
public class Pork implements FeedAPI {
    /**
     * Feed animal with pork
     *
     * @param animal: the animal to be fed
     */
    @Override
    public void feedAnimal(String animal) {
        System.out.println("Pork | " + animal + " are fed by pork!");
    }
}
