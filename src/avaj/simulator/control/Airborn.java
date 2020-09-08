package src.avaj.simulator.control;

import src.avaj.simulator.weather.WeatherTower;

public interface Airborn {
    void weatherUpdate();
    void registerToTower(WeatherTower weatherTower);
}