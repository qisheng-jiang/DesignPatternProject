package test;

import communication.MessageMediator;
import communication.client.AnimalDepartmentClient;
import communication.client.HeadquartersClient;
import communication.client.PlantDepartmentClient;

public class CommunicationTest {

    public static void main(String[] args) {
        // Proxy Pattern
        System.out.println("\n------Mediator Patten------\n");
        // set up
        MessageMediator messageMediator = new MessageMediator();
        HeadquartersClient headquarters = new HeadquartersClient("BOSS", "000", messageMediator);
        AnimalDepartmentClient animalDepartment = new AnimalDepartmentClient("Animal", "001", messageMediator);
        PlantDepartmentClient plantDepartment = new PlantDepartmentClient("Plant", "002", messageMediator);

        // add clients to mediator
        messageMediator.setHeadquarters(headquarters);
        messageMediator.setAnimalDepartment(animalDepartment);
        messageMediator.setPlantDepartment(plantDepartment);

        // send message to the two departments
        headquarters.sendMessage("Python is the best programming language in the world!");
        // send messages to each other
        animalDepartment.sendMessage("What does Boss mean? Is Python relevant to our farm?");
        plantDepartment.sendMessage("We don't know either.");
    }
}