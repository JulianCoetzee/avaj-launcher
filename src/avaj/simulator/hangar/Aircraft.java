package src.avaj.simulator.hangar;

import src.avaj.simulator.control.Coordinates;

public class Aircraft {
 
    protected long id;
    protected String callsign;
    protected Coordinates coords;
    private static long idIndex = 0;

    protected Aircraft(String callsign, Coordinates coords)
    {
        this.id = this.nextAC();
        this.callsign = callsign;
        this.coords = coords;
    }

    private long nextAC()
    {
        return ++(Aircraft.idIndex);
    }
}