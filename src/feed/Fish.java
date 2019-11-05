package feed;

/**
 * Fish feed
 *
 * @author RootReturn0
 * @Time 2019-10-25
 */
public class Fish implements FeedAPI {
    /**
     * Feed animal with fishes
     *
     * @param animal: the animal to be fed
     */
    @Override
    public void feedAnimal(String animal) {
        System.out.println("Fish | " + animal + " are fed by fishes!");
    }
}
