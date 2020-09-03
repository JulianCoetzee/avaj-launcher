package src.avaj.simulator.control;

public class Coordinates {
    private int longi;
    private int lati;
    private int h;
    
    public Coordinates(int longi, int lati, int h) {
        this.longi = longi;
        this.lati = lati;
        this.h = h;
    }

    public int getLongi() {
        return this.longi;
    }

    public int getLati() {
        return this.lati;
    }

    public int getH() {
        return this.h;
    }
}