package patternTest;

import farm.strategy.CatSound;
import farm.strategy.Duck;

public class StrategyTest {
    public static void StrategyTest(){
        System.out.println("\n------Strategy Pattern------\n");

        Duck duck=new Duck();//initialize a duck

        duck.speak();//default strategy: a duck speaks with duck's sound
        duck.speak(new CatSound());//choose the strategy you want:a duck speaks with the sound you want

    }
}
