package patternTest;

import Iterator.ConcreteSet;
import Iterator.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        ConcreteSet list = new ConcreteSet();
        list.add("123");
        list.add("456");
        list.add("789");
        for(Iterator it = list.iterator(); it.hasNext();)
        {
            System.out.println(it.next());
        }
    }
}
