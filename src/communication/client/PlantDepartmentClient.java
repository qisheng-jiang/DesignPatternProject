package communication.client;

import communication.Mediator;

/**
 * Client of plant department for message exchange
 *
 * @author RootReturn0
 * @Time 2019-10-25
 */
public class PlantDepartmentClient extends Client {

    /**
     * Set a new client for plant department
     *
     * @param name:     identify the user's name
     * @param id:       identify the user's ID
     * @param mediator: which kind of mediator the client is using
     */
    public PlantDepartmentClient(String name, String id, Mediator mediator) {
        super(name, id, mediator);
    }

    /**
     * Send message to animal department
     *
     * @param message: the message to be sent
     */
    public void sendMessage(String message) {
        System.out.println(
                "PlantDepartmentClient | ID: " + id + " Name: " + name + ", SEND: " + message);
        mediator.contact(message, this);
    }

    /**
     * Receive message
     *
     * @param message: the message Received
     */
    public void getMessage(String message) {
        System.out.println(
                "PlantDepartmentClient | ID: " + id + " Name: " + name + ", RECEIVE: " + message);
    }
}
