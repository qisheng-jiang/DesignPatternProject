package leave;

/**
 * Data structure of leave request
 *
 * @author RootReturn0
 * @Time 2019-10-25
 */
public class LeaveRequest {
    private String name; // the staff's name
    private int day; // the number of days the staff would like to leave

    /**
     * Set a new boss level handler for a request
     *
     * @param name: the name of the applicant
     * @param day:  the number of days to leave
     */
    public LeaveRequest(String name, int day) {
        this.name = name;
        this.day = day;
    }

    /**
     * Get the value of data
     *
     * @return the applicant's name
     **/
    public String getName() {
        return name;
    }

    /**
     * Get the value of data
     *
     * @return the number of days to leave
     **/
    public int getDay() {
        return day;
    }
}
