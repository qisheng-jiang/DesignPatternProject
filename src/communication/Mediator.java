package communication;

import communication.client.Client;

/**
 * Abstract class mediator
 *
 * @author RootReturn0
 * @Time 2019-10-25
 */
public abstract class Mediator {
    /**
     * Receive and send message to the right clients
     *
     * @param message: the message to be sent
     * @param client:  the client using this mediator
     */
    public abstract void contact(String message, Client client);
}
