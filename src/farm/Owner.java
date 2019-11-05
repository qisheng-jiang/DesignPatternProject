package farm;

import DAO.FarmerDAO;
import DAO.FarmerDAOImpl1;
import Filter.Fields;
import Shop.Shop;
import farm.command.BuyCommand;
import farm.command.Command;
import farm.command.SellCommand;
import farm.command.SowCommand;

//All farm property belongs to the owner
public class Owner {
    // Owner is the most powerful man!
    private boolean permission = true;

	//Get permission
    public boolean getPermission() {
        return permission;
    }

    //Buy a certain amount(param count) of objects(param name)
    public void buy(String name, int count) {
        Command cmd = new BuyCommand(name, count);
        cmd.execute();
    }

    //Sell a certain amount(param count) of products(param name)
    public void sell(String name, int count) {
        Command cmd = new SellCommand(name, count);
        cmd.execute();
    }

    //Plant a certain amount(param count) of a certain crops(param name)
    public void sow(Fields fields, String name, int count) {
        Command cmd = new SowCommand(fields, name, count);
        cmd.execute();
    }

    //Sell all products
    public void sellAll() {
        EmployeeFactory ef = EmployeeFactory.getInstance();
        Farmer f = ef.orderFarmer();
        if (f != null) {
            f.sellAll();
        } else
            System.out.println("Command Fail.");
    }

    //Apply certain type(param c) of Fertilizer in Field numbered praram k
    public void applyFertilizer(Fields fields, String c, Integer k) {
        EmployeeFactory ef = EmployeeFactory.getInstance();
        Farmer f = ef.orderFarmer();
        if (f != null) {
            f.applyFertilizer(fields, c, k);
        } else
            System.out.println("Command Fail.");
    }

    //Harvest crops growing on Field numbered praram k
    public void harvest(Fields fields, Integer k) {
        EmployeeFactory ef = EmployeeFactory.getInstance();
        Farmer f = ef.orderFarmer();
        if (f != null) {
            f.harvest(fields, k);
        } else
            System.out.println("Command Fail.");
    }

    //Harvest all crops
    public void harvestAll(Fields fields) {
        EmployeeFactory ef = EmployeeFactory.getInstance();
        Farmer f = ef.orderFarmer();
        if (f != null) {
            f.harvestAll(fields);
        } else
            System.out.println("Command Fail.");
    }

	//Hire a farmer
    public void hireFarmer(String name) {
        EmployeeFactory ef = EmployeeFactory.getInstance();
        Farmer f = new Farmer(name);
        if (f.getSalary() > Shop.fund) {
            System.out.println("Insufficient funds, unable to hire a Farmer!");
        } else {
            Shop.fund -= f.getSalary();
            ef.addEmployee(f);
            //db
            FarmerDAO farmerDB = FarmerDAOImpl1.getInstance();
            farmerDB.addFarmer(f);
            System.out.println("Hire Farmer " + f.getName() + " Successfully!");
        }
    }

}
