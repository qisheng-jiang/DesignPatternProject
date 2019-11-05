package patternTest;

import Shop.Shop;
import farm.Owner;

public class AbstractFactoryTest {

    public static void main(String[] args) {
        //test Prototype Pattern&Abstract Factory Pattern
        Owner owner = new Owner();
        System.out.println("\n------Abstract Factory Pattern------\n");
        System.out.println("Your funds：" + Shop.fund);
        System.out.println("Please enter your choice number!");
        System.out.println("1 Shop 2 View warehouse 3 Sell crop 4 Sell all crop \n" +
                "5 Plant 6 Harvest 7 Harvest all 8 View fields 9 Upgrade field \n" +
                "10 Apply fertilizer 11 Show tool bag 12 Hire farmer 13 View purchase History \n" +
                "0 Exit");
        System.out.println("1");
        Shop.showCatalogue();
        System.out.println("Please enter the name of the product you want to buy.");
        System.out.println("Cabbage");
        System.out.println("Please enter the quantity of goods to buy.");
        System.out.println("3");
        owner.buy("Cabbage", 3);
        //test Flyweight Pattern&Abstract Factory Pattern
        System.out.println("\n------Abstract Factory Pattern------\n");
        System.out.println("Your funds：" + Shop.fund);
        System.out.println("Please enter your choice number!");
        System.out.println("1");
        Shop.showCatalogue();
        System.out.println("Please enter the name of the product you want to buy.");
        System.out.println("SuperF");
        System.out.println("Please enter the quantity of goods to buy.");
        System.out.println("1");
        owner.buy("SuperF", 1);
    }
}
