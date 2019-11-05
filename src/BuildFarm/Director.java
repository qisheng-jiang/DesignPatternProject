package BuildFarm;

//导演类
public class Director {
    private FarmBuilder fbuilder=null;
    public Director(FarmBuilder builder) {
        fbuilder = builder;
    }
    public Farm construct(){
        fbuilder.setType();
        fbuilder.setArea();
        fbuilder.buildFence();
        fbuilder.buildFields();
        return fbuilder.constructFarm();
    }
}
