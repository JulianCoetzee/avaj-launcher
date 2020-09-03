package src.avaj.simulator.control;

import src.avaj.simulator.hangar.*;

public interface Airborn {
    void updateWeather();
    void registerToTower(Tower tower);
}