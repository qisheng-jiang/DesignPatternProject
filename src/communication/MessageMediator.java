package communication;

import communication.client.*;

/**
 * mediator for message exchange
 *
 * @author RootReturn0
 * @Time 2019-10-25
 */
public class MessageMediator extends Mediator {
    private AnimalDepartmentClient animalDepartment;
    private PlantDepartmentClient plantDepartment;
    private HeadquartersClient headquarters;

    /**
     * Set animal department in the mediator
     *
     * @param animalDepartment: the animal department client to be set
     */
    public void setAnimalDepartment(AnimalDepartmentClient animalDepartment) {
        this.animalDepartment = animalDepartment;
    }

    /**
     * Set plant department in the mediator
     *
     * @param plantDepartment: the plant department client to be set
     */
    public void setPlantDepartment(PlantDepartmentClient plantDepartment) {
        this.plantDepartment = plantDepartment;
    }

    /**
     * Set headquarters in the mediator
     *
     * @param headquarters: the headquarters client department to be set
     */
    public void setHeadquarters(HeadquartersClient headquarters) {
        this.headquarters = headquarters;
    }

    /**
     * Receive and send message to the right clients
     *
     * @param message: the message to be sent
     * @param client:  the client using this mediator
     */
    @Override
    public void contact(String message, Client client) {
        if (client == animalDepartment) {
            plantDepartment.getMessage(message);
        } else if (client == plantDepartment) {
            animalDepartment.getMessage(message);
        } else if (client == headquarters) {
            animalDepartment.getMessage(message);
            plantDepartment.getMessage(message);
        }
        // Here can be more ways to send messages to one or more client
    }
}
