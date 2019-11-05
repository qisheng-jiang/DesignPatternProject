package leave;

import java.util.Random;

/**
 * Handler for director to deal leave request
 *
 * @author RootReturn0
 * @Time 2019-10-25
 */
public class DirectorHandler extends RequestHandler {
    /**
     * Set a new director level handler for a request
     *
     * @param name: the director's name of the applicant
     */
    public DirectorHandler(String name) {
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
            System.out.println("DirectorHandler | Dear " + leaveRequest.getName()
                    + ", your request is not approved by Director " + name + " .");
        } else {
            System.out.println("DirectorHandler | Dear " + leaveRequest.getName()
                    + ", your request is approved by Director " + name + " .");
            if (leaveRequest.getDay() > 3) { // The days requested is more than 3 days
                nextHandler.process(leaveRequest); // Ask next level's staff to process
            } else {
                System.out.println("DirectorHandler | Dear " + leaveRequest.getName()
                        + ", your request has been confirmed for approval.");
            }
        }
    }

}
