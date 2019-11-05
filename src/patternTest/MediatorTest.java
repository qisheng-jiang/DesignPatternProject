package patternTest;

import communication.MessageMediator;
import communication.client.AnimalDepartmentClient;
import communication.client.HeadquartersClient;
import communication.client.PlantDepartmentClient;

public class MediatorTest {
    public static void mediatorTest() {
        System.out.println("\n------Mediator Pattern------\n");
        MessageMediator messageMediator = new MessageMediator();
        HeadquartersClient headquarters = new HeadquartersClient("BOSS", "000", messageMediator);
        AnimalDepartmentClient animalDepartment = new AnimalDepartmentClient("Animal", "001", messageMediator);
        PlantDepartmentClient plantDepartment = new PlantDepartmentClient("Plant", "002", messageMediator);

        messageMediator.setHeadquarters(headquarters);
        messageMediator.setAnimalDepartment(animalDepartment);
        messageMediator.setPlantDepartment(plantDepartment);

        headquarters.sendMessage("Python is the best programming language in the world!");
        System.out.println(" ");
        animalDepartment.sendMessage("What does Boss mean? Is Python relavent to our farm?");
        System.out.println(" ");
        plantDepartment.sendMessage("We don't know either.");
    }
}
