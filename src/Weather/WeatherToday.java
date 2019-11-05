package Weather;

import Filter.Field;
import Filter.Fields;

import java.util.ArrayList;
import java.util.List;

public class WeatherToday implements Weather {
    private String weather;

    private List<Observer>observers=new ArrayList<Observer>();

    public void setWeather(String weather){
        this.weather=weather;
        this.notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    @Override
    public void notifyAllObservers() {
        for(Observer observer:observers){
            observer.updateMoisture(weather);
        }
    }
}
