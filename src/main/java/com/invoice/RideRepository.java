package com.invoice;

import java.util.*;

public class RideRepository {
    Map<String, ArrayList> userRides = null;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    /**
     * Purpose : To get ride summary.
     *
     * @param userId : takes userID.
     * @param rides  : takes multiple rides.
     */
    public void addRide(String userId, Ride[] rides) {
        ArrayList<Ride> rideList = this.userRides.get(userId);
        if (rideList == null) {
            this.userRides.put(userId, new ArrayList<>(Arrays.asList(rides)));
        }
    }

    /**
     * Purpose : To get the ride details.
     *
     * @param userId : takes userID.
     * @return : List of rides.
     */
    public Ride[] getRides(String userId) {
        return (Ride[]) this.userRides.get(userId).toArray(new Ride[0]);
//        return this.userRides.get(userId).toArray(new Ride[0]);
    }
}
