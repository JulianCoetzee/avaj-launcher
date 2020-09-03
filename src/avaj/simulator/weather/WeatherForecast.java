package src.avaj.simulator.weather;

import src.avaj.simulator.control.Coordinates;

public class WeatherForecast {
    
    private static WeatherForecast Forecast = new WeatherForecast();
    private static String Weather[] = {"FOG", "RAIN", "SNOW", "SUN"};

    private WeatherForecast()
    {    
    }

    public static WeatherForecast getForecast()
    {
        return WeatherForecast.Forecast;
    }

    public String getWeather(Coordinates coords)
    {
        int selector = coords.getLongi() + coords.getLati() + coords.getH();

        return Weather[selector % 4];
    }
}