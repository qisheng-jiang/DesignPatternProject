package patternTest;

import BuildFarm.CommonFarmBuilder;
import BuildFarm.Director;
import BuildFarm.Farm;
import Filter.Field;
import Filter.Fields;
import Weather.WeatherToday;

public class ObserverTest {
    public static void observerTest(){
        System.out.println("\nobserverTest (Observer Pattern)\n");

        WeatherToday weatherToday = new WeatherToday();
        Farm farm;
        Director directorC = new Director(new CommonFarmBuilder());
        farm = directorC.construct();
        Fields f = farm.getFields();
        for (Field field : f.fields) {
            weatherToday.attach(field);
        }
        weatherToday.setWeather("rainy");
    }

    public static void main(String[] args) {
        observerTest();
    }
}
