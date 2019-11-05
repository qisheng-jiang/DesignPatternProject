package farm.command;

import Filter.Fields;
import farm.EmployeeFactory;
import farm.Farmer;

/*
 * Command Pattern
 * Owner order a farmer to sow plants.param name is the plant name, and count is the quantity of seeds.
 */
public class SowCommand implements Command {
	Fields fields;
	String name;
	int count;


	public SowCommand(Fields f, String n, int c) {
		fields=f;
		name=n;
		count=c;
	}
	
	@Override
	public void execute() {
		EmployeeFactory ef= EmployeeFactory.getInstance();
		Farmer e=ef.orderFarmer();
		if(e!=null){
			e.sow(fields,name,count);
		}else{
			System.out.println("Command Fail.");
		}
	}

}
