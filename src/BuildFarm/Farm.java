package BuildFarm;

import Filter.Fields;
import Weather.WeatherToday;

//农场类（产品类）
public class Farm {
    private String type;
    private Fields fields;
    private String fence;
    private String area;
    private WeatherToday weatherToday;

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type=type;
    }
    public String getFence(){
        return fence;
    }
    public void setFence(String fence){
        this.fence=fence;
    }
    public String getArea(){
        return area;
    }
    public void setArea(String area){
        this.area=area;
    }
    public Fields getFields(){
        return fields;
    }
    public void buildFields(Fields fields){
        this.fields=fields;
    }

    public WeatherToday getWeatherToday() {
        return weatherToday;
    }

    public void showDetails(){
        System.out.println("Farm type:"+this.getType());
        System.out.println("Farm fence:"+this.getFence());
        System.out.println("Farm area:"+this.getArea());
        System.out.println("Farm fields:");
        this.getFields().showDetail();
    }

}
