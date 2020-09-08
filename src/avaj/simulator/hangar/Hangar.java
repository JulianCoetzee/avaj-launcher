package src.avaj.simulator.hangar;

import src.avaj.simulator.control.*;

public class Hangar {
    
    public Airborn flight(String type, String callsign, int longi, int lati, int h)
    {
        if (longi < 0 || lati < 0 || h < 0)
        {
            System.out.println("Coordinates invalid. Positive integers only");
            return null;
        }
        Coordinates coords = new Coordinates(longi, lati, h);
        // System.out.println("Coords created for " + type);

        if (type.equals("Baloon"))
        {
            // System.out.println("Baloon created");
            return new Baloon(callsign, coords);
        }
        else if (type.equals("Helicopter"))
        {
            return new Helicopter(callsign, coords);
        }
        else if (type.equals("JetPlane"))
        {
            return new JetPlane(callsign, coords);
        }
        else
        {
            System.out.println("Hangar: " + type + " invalid. ONLY Baloon, Helicopter or JetPlane");
            return null;
        }
    }
}