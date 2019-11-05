package BuildFarm;

//抽象建造类
public abstract class FarmBuilder {
    abstract void setType();
    abstract void setArea();
    abstract void buildFence();
    abstract void buildFields();
    abstract Farm constructFarm();

}