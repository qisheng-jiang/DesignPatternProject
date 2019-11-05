package patternTest;

import Interpreter.AnimalInterpreterPattern;
import Interpreter.IExpression;

public class InterpreterTest {
    public static void main(String[] args) {
        System.out.println("\n------Interpreter Pattern------\n");
        IExpression isDog = AnimalInterpreterPattern.getDogExpression();
        IExpression isHen = AnimalInterpreterPattern.getHenExpression();
        System.out.println("John is a dog? " + isDog.interpret("John"));
        System.out.println("Julie is a hen? " + isHen.interpret("Hen Julie"));
    }
}
