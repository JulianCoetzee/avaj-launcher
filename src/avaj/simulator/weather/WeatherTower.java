package src.avaj.simulator.weather;

import src.avaj.simulator.control.*;


public class WeatherTower extends Tower {

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
            if (dr == 0)
            {
                dr = 1;
                i--;
            }
            i++;
        }
    }
}