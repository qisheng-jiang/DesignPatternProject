package communication.client;

import communication.Mediator;

/**
 * Client of headquarters for message exchange
 *
 * @author RootReturn0
 * @Time 2019-10-25
 */
public class HeadquartersClient extends Client {

    /**
     * Set a new client for headquarters
     *
     * @param name:     identify the user's name
     * @param id:       identify the user's ID
     * @param mediator: which kind of mediator the client is using
     */
    public HeadquartersClient(String name, String id, Mediator mediator) {
        super(name, id, mediator);
    }

    /**
     * Send message to animal and plant department
     *
     * @param message: the message to be sent
     */
    public void sendMessage(String message) {
        System.out.println("HeadquartersClient | ID: " + id + " Name: " + name + ", SEND: " + message);
        mediator.contact(message, this);
    }

    /**
     * Receive message
     *
     * @param message: the message Received
     */
    public void getMessage(String message) {
        System.out.println(
                "HeadquartersClient | ID: " + id + " Name: " + name + ", Receive: " + message);
    }
}
