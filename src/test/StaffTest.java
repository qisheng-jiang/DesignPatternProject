package test;

import BuildFarm.Farm;
import DAO.FarmerDAO;
import DAO.FarmerDAOImpl1;
import Decorator.animals.DomesticQuarantineDecorator;
import Decorator.animals.HatDecorator;
import Decorator.farmers.MowerDecorator;
import Decorator.farmers.WateringPotDecorator;
import Iterator.ConcreteSet;
import Iterator.Iterator;
import farm.Employee;
import farm.EmployeeFactory;
import farm.Farmer;
import farm.Owner;
import farm.strategy.Animal;
import farm.strategy.Donkey;
import financial.PayProxy;
import leave.BossHandler;
import leave.DirectorHandler;
import leave.LeaveRequest;
import leave.ManagerHandler;

public class StaffTest {

    public static void main(String[] args) {
        Owner owner = new Owner();

        // Two farmers will be created when ef is initialed, along with DAO test
        EmployeeFactory ef = EmployeeFactory.getInstance();

        owner.hireFarmer("Farmer1");
        owner.hireFarmer("Farmer2");

        // Null Object Pattern, along with DAO test
        System.out.println("\n------Null Object Pattern-------\n");
        Employee tempFarmer1 = ef.findEmployee("Farmer1");
        Employee tempFarmer2 = ef.findEmployee("Farmer007");
        //Employee tempFarmer3 = ef.findEmployee("TEST CD");
        System.out.println("Result of Farmer1: " + tempFarmer1.getName());
        System.out.println("Result of Farmer007: " + tempFarmer2.getName());

        // Iterator Pattern
        System.out.println("\n------Iterator Pattern-------\n");
        ConcreteSet names = new ConcreteSet();
        names.add(tempFarmer1.getName());
        names.add(tempFarmer2.getName());
        for (Iterator it = names.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }

        // Command Pattern
        System.out.println("\n------Command Pattern------\n");
        owner.buy("Tomato", 10);

        // Chain of Responsibility Pattern
        System.out.println("\n------Chain of Responsibility Pattern------\n");
        leaveRequest("Farmer1", 10);

        // Proxy Pattern
        System.out.println("\n------Proxy Pattern------\n");
        System.out.println("The owner is trying to pay salary.");
        PayProxy pay1 = new PayProxy(owner.getPermission());
        pay1.welcome();
        pay1.pay();
        System.out.println("\nA farmer is trying to pay salary.");
        Farmer tempFarmer = new Farmer();
        PayProxy pay2 = new PayProxy(tempFarmer.getPermission());
        pay2.welcome();
        pay2.pay();

        //test decorator(there is another part for decorator testing in AnimalTest.java)
        System.out.println("\n------Decorator Pattern II------\n");
        Farmer myFarmer = new Farmer();
        myFarmer = new MowerDecorator(myFarmer);
        myFarmer.doMower();
        myFarmer.doShovel();
        myFarmer = new WateringPotDecorator(myFarmer);
        myFarmer.doWateringPot();
        myFarmer.showDecoration();
        System.out.println("");

        //test DAO(actually this part was tested implicitly at the front of this text)
        System.out.println("\n------Data Access Object Pattern------\n");
        //you can choose which implementation of FarmerDAO to use
        //to be more specific, you can operate on different databases
        //FarmerDAO farmerDAO = new FarmerDAOImpl1();
        FarmerDAO farmerDB = FarmerDAOImpl1.getInstance();
        //output all farmers
        for (Farmer farmer : farmerDB.getAllFarmers()) {
            System.out.println("Farmer: " + farmer.getName());
        }
        //look up farmer
        farmerDB.getFarmer("TEST CD");
        farmerDB.getFarmer("A");
    }

    public static void leaveRequest(String name, int day) {
        // Chain of Responsibility Pattern
        LeaveRequest leaveRequest = new LeaveRequest(name, day);
        DirectorHandler directorHandler = new DirectorHandler("Mr.D");
        ManagerHandler managerHandler = new ManagerHandler("Mr.M");
        BossHandler bossHandler = new BossHandler("Mr.B");

        directorHandler.setNext(managerHandler);
        managerHandler.setNext(bossHandler);

        directorHandler.process(leaveRequest);
    }
}