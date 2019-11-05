package financial;

/**
 * Proxy operation of paying salary
 * Use permission check before important operation
 *
 * @author RootReturn0
 * @Time 2019-10-25
 */
public class PayProxy implements PaySalary {
    private Pay realPay = new Pay(); // real instance
    private boolean permission;

    /**
     * Set the user's permission
     *
     * @param permission: user's permission
     */
    public PayProxy(boolean permission) {
        this.permission = permission;
    }

    /**
     * Show welcome worlds when user log in the salary system
     * Don't need to check permission
     */
    @Override
    public void welcome() {
        realPay.welcome();
    }

    /**
     * Do the operation of pay after permission check
     * Need to check permission
     */
    @Override
    public void pay() {

        // check permission
        if (permission) {
            realPay.pay();
        } else {
            System.out.println("PayProxy | Operation \"pay\" failed! Permission denied!");
        }
    }
}
