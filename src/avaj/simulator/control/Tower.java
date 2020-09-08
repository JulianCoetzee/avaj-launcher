package src.avaj.simulator.control;

import java.util.*;

public class Tower {
    public List<Airborn> registered = new ArrayList<Airborn>();

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
}