package patternTest;

import Filter.Fields;
import farm.EmployeeFactory;
import farm.Owner;

public class CommandTest {
    public static void CommandTest() throws InterruptedException {
        System.out.println("\n------Command Pattern------\n");

        Fields f=new Fields();//initialize fields
        Owner owner=new Owner();//initialize an owner who issue an order

        owner.buy("Tomato", 10);//Buy Command
        owner.sow(f,"Tomato",2);//Sow Command
        owner.sell("Tomato",1);//Sell Command.
        // It takes several seconds for crops to manure,
        // and the Sell Command will fail because no crops can be sold right now.

    }

    public static void main(String[] args) throws InterruptedException{
        CommandTest();
    }
}
