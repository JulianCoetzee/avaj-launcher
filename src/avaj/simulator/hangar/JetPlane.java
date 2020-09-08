package src.avaj.simulator.hangar;

import java.util.HashMap;

import src.avaj.simulator.Simulator;
import src.avaj.simulator.control.*;
import src.avaj.simulator.weather.WeatherTower;

public class JetPlane extends Aircraft implements Airborn {

    private WeatherTower weatherTower;

    JetPlane(String callsign, Coordinates coords)
    {
        super(callsign, coords);
    }

    public void registerToTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.registerAC(this);
        Simulator.output.println("Tower: JetPlane#" + this.callsign + "(" + this.id +"): " + "registered to tower");
    }

    public void weatherUpdate()
    {        
        String weather = weatherTower.weatherMan(this.coords);
        HashMap<String, String> radioLog = new HashMap<String, String>() {{
            put("FOG", "This shouldn't be possible at cruising altitude");
            put("RAIN", "Watch the chop");
            put("SNOW", "Can't see nothing, Cpt. Snow");
            put("SUN", "Aviators, gents");
        }};

        if (weather == "FOG")
        {
            this.coords = new Coordinates(coords.getLongi(), coords.getLati() + 1, coords.getH());
        }
        if (weather == "RAIN")
        {
            this.coords = new Coordinates(coords.getLongi(), coords.getLati()  + 5, coords.getH());
        }
        if (weather == "SNOW")
        {
            this.coords = new Coordinates(coords.getLongi(), coords.getLati(), coords.getH() - 7);
        }
        if (weather == "SUN")
        {
            this.coords = new Coordinates(coords.getLongi(), coords.getLati() + 10, coords.getH() + 2);
        }

        Simulator.output.println("JetPlane#" + this.callsign + "(" + this.id +"): " + radioLog.get(weather));
        if (this.coords.getH() <= 0)
        {
            Simulator.output.println("JetPlane#" + this.callsign + "(" + this.id +"): " + "landing safely.");
            this.weatherTower.unregisterAC(this);
            Simulator.output.println("Tower: JetPlane#" + this.callsign + "(" + this.id +"): " + "deregistered from tower");
        }
    }
}