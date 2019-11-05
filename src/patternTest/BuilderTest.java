package patternTest;

import BuildFarm.CommonFarmBuilder;
import BuildFarm.Director;
import BuildFarm.Farm;

public class BuilderTest {
    public static void main(String[] args) {
        System.out.println("\n------Builder Pattern------\n");
        System.out.println("Choose the farm construction type:");
        System.out.println("1 common 2 super");
        System.out.println("1");
        Farm farm;
        Director directorC = new Director(new CommonFarmBuilder());
        farm = directorC.construct();
        farm.showDetails();
    }
}
