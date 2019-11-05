package BuildFarm;

import Filter.Fields;

//具体建造类
public class SuperFarmBuilder extends  FarmBuilder {
    private Farm farm=new Farm();
    @Override
    public void setType(){
        farm.setType("superFarm");
    }
    @Override
    public void setArea(){
        farm.setArea("2000 m^2");
    };
    @Override
    public void buildFence(){
        farm.setFence("White Fence");
    }
    @Override
    public void buildFields(){
        farm.buildFields(new Fields(8));
    }
    @Override
    public Farm constructFarm(){
        return farm;
    }

}
