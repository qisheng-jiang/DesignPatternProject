package patternTest;

import farm.strategy.*;
import feed.*;

public class BridgeTest {

    public static void bridgeTest() {
        System.out.println("\n------Bridge Pattern------\n");

        FeedAPI grass = new Grass();
        FeedAPI cereal = new Cereal();

        Animal cow = new Cow();
        Animal duck = new Duck();

        cow.setFeedAPI(grass);
        duck.setFeedAPI(cereal);

        cow.feed();
        duck.feed();
    }
}