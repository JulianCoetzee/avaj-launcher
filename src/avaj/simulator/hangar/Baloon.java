package src.avaj.simulator.hangar;

import java.util.HashMap;

import src.avaj.simulator.Simulator;
import src.avaj.simulator.control.*;

public class Baloon extends Aircraft implements Airborn {

    private Tower tower;

    Baloon(String callsign, Coordinates coords)
    {
        super(callsign, coords);
    }
    
    public void registerToTower(Tower tower)
    {
        this.tower = tower;
        this.tower.registerAC(this);
        Simulator.output.println("Tower: Baloon#" + this.callsign + "(" + this.id +"): " + "registered to tower");
    }

    public void weatherUpdate()
    {        
        String weather = tower.weatherMan(this.coords);
        HashMap<String, String> radioLog = new HashMap<String, String>() {{
            put("FOG", "Who turned off the sun?");
            put("RAIN", "Wish I had a cabin :(");
            put("SNOW", "More fire puhleeze!");
            put("SUN", "Get my sunglasses");
        }};

        if (weather == "FOG")
        {
            this.coords = new Coordinates(coords.getLongi(), coords.getLati(), coords.getH() - 3);
        }
        if (weather == "RAIN")
        {
            this.coords = new Coordinates(coords.getLongi(), coords.getLati(), coords.getH() - 5);
        }
        if (weather == "SNOW")
        {
            this.coords = new Coordinates(coords.getLongi(), coords.getLati(), coords.getH() - 15);
        }
        if (weather == "SUN")
        {
            this.coords = new Coordinates(coords.getLongi() + 2, coords.getLati(), coords.getH() + 4);
        }
        
        Simulator.output.println("Baloon#" + this.callsign + "(" + this.id +"): " + radioLog.get(weather));
        if (this.coords.getH() <= 0)
        {
            Simulator.output.println("Baloon#" + this.callsign + "(" + this.id +"): " + "landing safely.");
            this.tower.unregisterAC(this);
            Simulator.output.println("Tower: Baloon#" + this.callsign + "(" + this.id +"): " + "deregistered from tower");
        }
    }
}