package DAO;

import farm.Farmer;
import java.util.ArrayList;
import java.util.List;

public class FarmerDAOImpl2 implements FarmerDAO {

    //List here acts as database to keep things simple
    private ArrayList<Farmer> farmersDB2;
    //singleton
    private static FarmerDAOImpl2 instance=new FarmerDAOImpl2();

    private FarmerDAOImpl2(){
        farmersDB2 = new ArrayList<Farmer>();
        farmersDB2.add(new Farmer("TEST CD2"));
    }

    public static FarmerDAOImpl2 getInstance(){
        if(instance==null) {
            instance=new FarmerDAOImpl2();
        }
        return instance;
    }

    @Override
    public void deleteFarmer(Farmer farmer) {
        farmersDB2.remove(farmer);
        System.out.println("Farmer: Name " + farmer.getName()
                +", deleted from database");
    }

    @Override
    public ArrayList<Farmer> getAllFarmers() {
        return farmersDB2;
    }

    @Override
    public Farmer getFarmer(String name) {
        for (Farmer i:farmersDB2
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
        farmersDB2.add(farmer);
    }

}