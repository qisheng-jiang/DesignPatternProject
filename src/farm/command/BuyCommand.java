package farm.command;

import farm.EmployeeFactory;
import farm.Farmer;

/*
 * Command Pattern
 * Owner order a farmer to buy something.param name is the product name, and count is the quantity of product.
 */
public class BuyCommand implements Command{
	String name;
	int count;

	public BuyCommand(String n, int c) {
		name=n;
		count=c; 
	}

	@Override
	public void execute() {
		EmployeeFactory ef=EmployeeFactory.getInstance();
		Farmer e=ef.orderFarmer();
		if(e!=null){
			e.buy(name,count);
		}else{
			System.out.println("Command Fail.");
		}
	}

}
