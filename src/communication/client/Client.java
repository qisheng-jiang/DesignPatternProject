package communication.client;

import communication.Mediator;

/**
 * Root of all client
 *
 * @author RootReturn0
 * @Time 2019-10-25
 */
public abstract class Client {
    protected String name;
    protected String id;
    protected Mediator mediator;

    /**
     * Set a new client
     *
     * @param name:     identify the user's name
     * @param id:       identify the user's ID
     * @param mediator: which kind of mediator the client is using
     */
    public Client(String name, String id, Mediator mediator) {
        this.name = name;
        this.id = id;
        this.mediator = mediator;
    }
}
