package patternTest;

import BuildFarm.CommonFarmBuilder;
import BuildFarm.Director;
import BuildFarm.Farm;
import Filter.Field;
import Filter.Fields;
import Visitor.FieldVisitor;
import Weather.WeatherToday;

public class VisitorTest {
    public static void visitorTest(){
        System.out.println("\nvisitorTest (Visitor Pattern)\n");

        FieldVisitor fieldVisitor = new FieldVisitor();
        Farm farm;
        Director directorC = new Director(new CommonFarmBuilder());
        farm = directorC.construct();
        Fields f = farm.getFields();
        for (Field field : f.fields) {
            field.accept(fieldVisitor);
        }
    }

    public static void main(String[] args) {
        visitorTest();
    }
}
