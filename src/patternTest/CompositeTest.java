package patternTest;

import Tools.Bag;
import Tools.Hoe;
import Tools.Shovel;
import Tools.Sickle;

public class CompositeTest {
    public static void compositeTest(){
        System.out.println("\ncompositeTest (Composite Pattern)\n");

        Bag myBag = new Bag(new Hoe(), new Bag(new Shovel(), new Bag(new Sickle())));
        myBag.show(0);
    }

    public static void main(String[] args) {
        compositeTest();
    }
}
