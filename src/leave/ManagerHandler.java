package leave;

import java.util.Random;

/**
 * Handler for manager to deal leave request
 *
 * @author RootReturn0
 * @Time 2019-10-25
 */
public class ManagerHandler extends RequestHandler {
    /**
     * Set a new manager level handler for a request
     *
     * @param name: the manager's name of the applicant
     */
    public ManagerHandler(String name) {
        super(name);
    }

    /**
     * Process the request
     *
     * @param leaveRequest: the request to be processed
     */
    @Override
    public void process(LeaveRequest leaveRequest) {
        boolean result = (new Random().nextInt(10)) > 3; // Decide if the request is approved by random
        if (result == false) {
            System.out.println("ManagerHandler | Dear " + leaveRequest.getName()
                    + ", your request is not approved by Manager " + name + " .");
        } else {
            System.out.println("ManagerHandler | Dear " + leaveRequest.getName()
                    + ", your request is approved by Manager " + name + " .");
            if (leaveRequest.getDay() > 7) {// The days requested is more than 7 days
                nextHandler.process(leaveRequest); // Ask next level's staff to process
            } else {
                System.out.println("ManagerHandler | Dear " + leaveRequest.getName()
                        + ", your request has been confirmed for approval.");
            }
        }
    }
}
