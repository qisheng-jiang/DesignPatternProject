package leave;

/**
 * Abstract class, handler to deal leave request
 *
 * @author RootReturn0
 * @Time 2019-10-25
 */
public abstract class RequestHandler {
    protected String name;
    protected RequestHandler nextHandler;

    /**
     * Set a new handler for a request
     *
     * @param name: the user's name of the handler
     */
    public RequestHandler(String name) {
        this.name = name;
    }

    /**
     * Set the next level to deal request
     *
     * @param next: next level's position
     */
    public void setNext(RequestHandler next) {
        this.nextHandler = next;
    }

    /**
     * Process the request
     *
     * @param leaveRequest: the request to be processed
     */
    public abstract void process(LeaveRequest leaveRequest);
}
