package farm;

import DAO.FarmerDAO;
import DAO.FarmerDAOImpl1;

import java.util.ArrayList;

/*
 * A Factory used to manage staff.
 */
public class EmployeeFactory {
	private static EmployeeFactory instance=new EmployeeFactory();
	private  ArrayList<Employee> employees;
	
	//Default constructor:There are 2 farmers in the farm.
	EmployeeFactory(){
		employees=new ArrayList<Employee>();
		//Restore from database
		FarmerDAO farmerDB = FarmerDAOImpl1.getInstance();
		employees.addAll(farmerDB.getAllFarmers());
		employees.add(new Farmer("farmer1"));
		employees.add(new Farmer("farmer2"));

	}

	public static EmployeeFactory getInstance(){
		if(instance==null) {
			instance=new EmployeeFactory();
		}
		return instance;
	}

	//Find the employee named "name".
	public Employee findEmployee(String name) {
		for(int i=0;i<employees.size();i++) {
			if((employees.get(i)).getName()==name) {
				return employees.get(i);
			}
		}
		
		return new NullEmployee();		
	}
	
	//Find a idle employee to do task
	public Employee orderEmployee() {
		for(int i=0;i<employees.size();i++) {
			if((employees.get(i)).getStatus()==false) {
				return employees.get(i);
			}
		}
		System.out.println("All the staff are busy.");
		return new NullEmployee();
	}

	//Find a idle farmer to do task
	public Farmer orderFarmer() {
		for(int i=0;i<employees.size();i++) {
			if(((employees.get(i)).getStatus()==false)&&(employees.get(i) instanceof Farmer)) {
				return (Farmer)employees.get(i);
			}
		}
		System.out.println("All the farmers are busy.");
		return null;
	}

	//Add a Employee
	public void addEmployee(Employee e){
		employees.add(e);
	}
}
