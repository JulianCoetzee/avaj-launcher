package src.avaj.simulator.control;

import java.util.*;

import src.avaj.simulator.weather.WeatherForecast;

public class Tower {
    private List<Airborn> registered = new ArrayList<Airborn>();

    public void registerAC(Airborn newAircraft)
    {
        if (registered.contains(newAircraft))
            return ;
        registered.add(newAircraft);
    }

    public void unregisterAC(Airborn landed)
    {
        registered.remove(landed);
    }

    public String weatherMan(Coordinates coords)
    {
        return WeatherForecast.getForecast().getWeather(coords);
    }

    public void weatherChange()
    {
        int i;

        i = 0;
        while (i < registered.size())
        {
            registered.get(i).weatherUpdate();
            i++;
        }
    }
}