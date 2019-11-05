package financial;

/**
 * Real operation of paying salary
 *
 * @author RootReturn0
 * @Time 2019-10-25
 */
public class Pay implements PaySalary {

	// Show welcome worlds when user log in the salary system
    public void welcome() {
        System.out.println("Pay | Welcome to Salary System!");
    }

    // do operation of pay
    public void pay() {
        System.out.println("Pay | Operation \"pay\" succeed!");
    }
}
