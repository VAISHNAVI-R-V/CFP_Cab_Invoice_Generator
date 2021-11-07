package com.invoice;

public class Ride {
    public final double distance;
    public final int time;
    public CabRide cabRide;


    public Ride(CabRide cabRide, double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.cabRide = cabRide;
    }
}
