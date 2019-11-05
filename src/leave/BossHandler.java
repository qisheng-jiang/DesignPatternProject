package leave;

import java.util.Random;

/**
 * Handler for boss to deal leave request
 *
 * @author RootReturn0
 * @Time 2019-10-25
 */
public class BossHandler extends RequestHandler {
    /**
     * Set a new boss level handler for a request
     *
     * @param name: the boss's name of the applicant
     */
    public BossHandler(String name) {
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
            System.out.println("BossHandler | Dear " + leaveRequest.getName()
                    + ", your request is not approved by Boss " + name + " .");
        } else {
            // Boss is the top level!
            System.out.println("BossHandler | Dear " + leaveRequest.getName()
                    + ", your request is approved by Boss " + name + " .");
            System.out.println("BossHandler | Dear " + leaveRequest.getName()
                    + ", your request has been confirmed for approval.");
        }
    }
}
