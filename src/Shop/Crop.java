package Shop;

public interface Crop {
    //Get name
    String getName();
    //Get growtime
    Integer getGrowTime();
    //Get yield
    Integer getYield();
    //Get price
    Integer getPrice();
    //Get cost
    Integer getCost();
    //Buying crop
    boolean purchase(Integer num);
    //clone crop object
    Object clone();
}
