package patternTest;

import WH.Warehouse;

public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("\n------Singleton Pattern------\n");
        Warehouse w = Warehouse.getInstance();
        w.showItems();
    }
}
