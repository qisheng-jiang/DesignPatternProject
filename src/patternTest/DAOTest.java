package patternTest;

import DAO.FarmerDAO;
import DAO.FarmerDAOImpl1;
import farm.Farmer;

public class DAOTest {
    public static void DAOTest() {
        //you can choose which implementation of FarmerDAO to use
        //to be more specific, you can operate on different databases
        //FarmerDAO farmerDAO = new FarmerDAOImpl1();
        FarmerDAO farmerDB = FarmerDAOImpl1.getInstance();
        //add farmer
        farmerDB.addFarmer(new Farmer("ABC"));
        //output all farmers
        for (Farmer farmer : farmerDB.getAllFarmers()) {
            System.out.println("Farmer: " + farmer.getName());
        }
        //look up farmer
        farmerDB.getFarmer("TEST CD");
        farmerDB.getFarmer("ABC");
    }
}
