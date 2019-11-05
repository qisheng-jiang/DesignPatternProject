package farm;

/*
 * Null Object Pattern
 * We use this class to show that a certain employee does not exist.
 */
public class NullEmployee extends Employee {
	
	// Determine if the employee is empty.
	@Override
	public boolean isNil() {
		// TODO Auto-generated method stub
		return true;
	}

	//Return a reminder that the employee does not exist.
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "This employee does not exist.";
	}

}
