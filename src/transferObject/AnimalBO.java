package transferObject;

import memento.*;

import java.util.ArrayList;
import java.util.List;

public class AnimalBO {

    //列表是当作一个数据库
    //List is treated as a database
    List<AnimalVO> animals;

    public AnimalBO(){
        animals = new ArrayList<>();
        AnimalVO animal1 = new AnimalVO("Pig",10);
        AnimalVO animal2 = new AnimalVO("Cow",11);
        animals.add(animal1);
        animals.add(animal2);
    }

    public void deleteanimal(AnimalVO animal) {
        animals.remove(animal.getTotal());
        System.out.println("animal:" + animal.getKind() + ",total:"
                + animal.getTotal() +", deleted from database");
    }

    //从数据库中检索动物的名单
    //Search for a list of animals from the database
    public List<AnimalVO> getAllAnimals() {
        return animals;
    }

    public AnimalVO getAnimal(String kind) {
        for (AnimalVO i:animals
             ) {
            if (i.getKind().equalsIgnoreCase(kind)){
                return i;
            }
        }
        return null;
    }

    public boolean updateAnimal(AnimalVO animal) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getKind().equalsIgnoreCase(animal.getKind())){
                animals.set(i, animal);
                System.out.println("animal:"+ animal.getKind() +" updated in the database");
                return true;
            }
        }
        System.out.println("animal:"+ animal.getKind() +" not found in the database");
        return false;
    }

}
