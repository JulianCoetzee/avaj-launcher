package src.avaj.simulator.hangar;

import src.avaj.simulator.control.*;

public class Hangar {
    
    public Airborn Flight(String type, String callsign, int longi, int lati, int h)
    {
        Coordinates coords = new Coordinates(longi, lati, h);

        if (type.toLowerCase() == "baloon")
        {
            return new Baloon(callsign, coords);
        }
        else if (type.toLowerCase() == "helicopter")
        {
            return new Helicopter(callsign, coords);
        }
        else if (type.toLowerCase() == "jetplane")
        {
            return new Helicopter(callsign, coords);
        }
        return null;
    }
}