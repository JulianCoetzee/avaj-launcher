package src.avaj.simulator.hangar;

import java.util.*;

import src.avaj.simulator.Simulator;
import src.avaj.simulator.control.*;

public class Helicopter extends Aircraft implements Airborn {

    private Tower tower;

    Helicopter(String callsign, Coordinates coords)
    {
        super(callsign, coords);
    }

    public void registerToTower(Tower tower)
    {
        this.tower = tower;
        this.tower.registerAC(this);
        Simulator.output.println("Tower: Helicopter#" + this.callsign + "(" + this.id +"): " + "registered to tower");

    }

    public void weatherUpdate()
    {        
        String weather = tower.weatherMan(this.coords);
        HashMap<String, String> radioLog = new HashMap<String, String>() {{
            put("FOG", "Can't see cap'n");
            put("RAIN", "There's a leak in the ceiling");
            put("SNOW", "Hehe, I'm in danger");
            put("SUN", "I can see clearly now");
        }};

        if (weather == "FOG")
        {
            this.coords = new Coordinates(coords.getLongi() + 1, coords.getLati(), coords.getH());
        }
        else if (weather == "RAIN")
        {
            this.coords = new Coordinates(coords.getLongi() + 5, coords.getLati(), coords.getH());
        }
        else if (weather == "SNOW")
        {
            this.coords = new Coordinates(coords.getLongi(), coords.getLati(), coords.getH() - 12);
        }
        else if (weather == "SUN")
        {
            this.coords = new Coordinates(coords.getLongi() + 10, coords.getLati(), coords.getH() + 2);
        }

        Simulator.output.println("Helicoper#" + this.callsign + "(" + this.id +"): " + radioLog.get(weather));
        if (this.coords.getH() <= 0)
        {
            Simulator.output.println("Helicopter#" + this.callsign + "(" + this.id +"): " + "landing safely.");
            this.tower.unregisterAC(this);
            Simulator.output.println("Tower: Helicopter#" + this.callsign + "(" + this.id +"): " + "deregistered from tower");
        }
    }
}