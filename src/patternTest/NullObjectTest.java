package patternTest;

import farm.Employee;
import farm.EmployeeFactory;
import farm.Farmer;

public class NullObjectTest {
    public static void NullObjectTest(){
        System.out.println("\n------Null Object Pattern------\n");

        EmployeeFactory ef=EmployeeFactory.getInstance();//initialize employees
        ef.addEmployee(new Farmer("XiaoMing"));//add a farmer named XiaoMing

        //find employee
        Employee e1,e2;
        e1=ef.findEmployee("XiaoMing");
        //e2 is a Null Object, which will return "not exist" when you search for its name
        e2=ef.findEmployee("LaoWang");
        System.out.println("Search for employee 1:"+e1.getName());
        System.out.println("Search for employee 2:"+e2.getName());

    }
}
