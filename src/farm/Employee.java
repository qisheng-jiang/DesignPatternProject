package farm;

import java.util.Timer;
import java.util.TimerTask;

/*
 * Employees hired by the owner
 */
public abstract class Employee {
    protected String name;
    protected boolean isbusy;
    protected boolean permisson = false;
    Integer cost;


    //Determine if the employee exists.
    public abstract boolean isNil();

    //Get employee's name
    public abstract String getName();

    //Change employee's permission
    public void setPermission(boolean permission) {
        this.permisson = permission;
    }

    ;

    //Get salary
    public Integer getSalary() {
        return cost;
    }

    //Get status
    public boolean getStatus() {
        return isbusy;
    }

    //Get permission status
    public boolean getPermission() {
        return permisson;
    }

    //Work
    public void work() {
        isbusy = false;
    }

    public void work(int s) {
        work();
        //set schedule
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    rest();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // 中断线程
                timer.cancel();
            }
        }, s * 1000);
    }

    //Rest
    public void rest() {
        isbusy = false;
    }

}
