package Shop;

public interface Fertilizer {
    //Get price
    Integer getPrice();
    //Get name
    String getName();
    //Buying fertilizer
    boolean purchase(Integer num);
}
