package com.invoice;

public class Ride {
    public final double distance;
    public final int time;

    public Ride(CabRide normal, double distance, int time) {
        this.distance = distance;
        this.time = time;
    }
}
