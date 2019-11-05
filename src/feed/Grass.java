package feed;

/**
 * Grass feed
 *
 * @author RootReturn0
 * @Time 2019-10-25
 */
public class Grass implements FeedAPI {
	/**
	 * Feed animal with grasses
	 * 
	 * @param animal: the animal to be fed
	 */
	@Override
	public void feedAnimal(String animal) {
		System.out.println("Grass | " + animal + " are fed by grasses!");
	}
}
