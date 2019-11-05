package DAO;

import farm.Farmer;

import java.util.ArrayList;
import java.util.List;

public interface FarmerDAO {
    ArrayList<Farmer> getAllFarmers();
    Farmer getFarmer(String name);
    void deleteFarmer(Farmer farmer);
    void addFarmer(Farmer farmer);
}