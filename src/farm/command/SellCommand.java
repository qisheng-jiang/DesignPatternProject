package farm.command;

import farm.EmployeeFactory;
import farm.Farmer;

/*
 * Command Pattern
 * Owner order a farmer to sell something.param name is the product name, and count is the quantity of product.
 */
public class SellCommand implements Command {
	String name;
	int count;
	
	public SellCommand(String n,int c) {
		name=n;
		count=c;
	}
	
	@Override
	public void execute() {
		EmployeeFactory ef= EmployeeFactory.getInstance();
		Farmer e=ef.orderFarmer();
		if(e!=null){
			e.sell(name,count);
		}else{
			System.out.println("Command Fail.");
		}

	}

}
