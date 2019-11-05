import Filter.Fields;
import farm.Farmer;

public class FacadeTest {
    public static void FacadeTest(){
        System.out.println("\n------Facade Pattern------\n");

        Farmer farmer=new Farmer();//initialize a farmer
        Fields f=new Fields();//initialize fields

        farmer.buy("Tomato",2);//buy some seeds
        farmer.sow(f,"Tomato",1);//sow
        //all the complex sowing steps have been packaged in the seederFacade.

    }
}
