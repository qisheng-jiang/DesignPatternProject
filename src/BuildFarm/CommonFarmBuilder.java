package BuildFarm;

import Filter.Fields;

//具体建造类
public class CommonFarmBuilder extends FarmBuilder {
    private Farm farm=new Farm();
    @Override
    public void setType(){
        farm.setType("commonFarm");
    }
    @Override
    public void setArea(){
        farm.setArea("100 m^2");
    };
    @Override
    public void buildFence(){
        farm.setFence("Yellow Fence");
    }
    @Override
    public void buildFields(){
        farm.buildFields(new Fields(6));
    }
    @Override
    public Farm constructFarm(){
        return farm;
    }

}
