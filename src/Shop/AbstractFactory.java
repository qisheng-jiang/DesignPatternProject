package Shop;

public abstract class AbstractFactory {
    public abstract Crop getCrop(String crop);
    public abstract Fertilizer getFertilizer(String fertilizer) ;
}

