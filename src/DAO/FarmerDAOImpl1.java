package DAO;

import farm.EmployeeFactory;
import farm.Farmer;
import java.util.ArrayList;
import java.util.List;

public class FarmerDAOImpl1 implements FarmerDAO {

    //List here acts as database to keep things simple
    private ArrayList<Farmer> farmersDB1;
    //singleton
    private static FarmerDAOImpl1 instance=new FarmerDAOImpl1();

    private FarmerDAOImpl1(){
        farmersDB1 = new ArrayList<Farmer>();
    }

    public static FarmerDAOImpl1 getInstance(){
        if(instance==null) {
            instance=new FarmerDAOImpl1();
        }
        return instance;
    }
    @Override
    public void deleteFarmer(Farmer farmer) {
        farmersDB1.remove(farmer);
        System.out.println("Farmer: Name " + farmer.getName()
                +", deleted from database");
    }

    @Override
    public ArrayList<Farmer> getAllFarmers() {
        return farmersDB1;
    }

    @Override
    public Farmer getFarmer(String name) {
        for (Farmer i:farmersDB1
        ) {
            if (i.getName().equals(name)){
                System.out.println(i.getName()+"Exists");
                return i;
            }
        }
        System.out.println("Not Found");
        return null;
    }

    @Override
    public void addFarmer(Farmer farmer){
        farmersDB1.add(farmer);
    }

}