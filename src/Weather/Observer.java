package Weather;

import Filter.Field;

public abstract class Observer {
    protected WeatherToday weatherToday;
    //Update the moisture of the field;
    public abstract void updateMoisture(String weather);
}
