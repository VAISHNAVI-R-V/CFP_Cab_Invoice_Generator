package com.invoice;

public enum CabRide {
    NORMAL(10.0, 1.0, 5.0), PREMIUM(15, 2, 20);

    private final double costPerKm;
    private final double costPerMin;
    private final double minimumFarePerRide;

    CabRide(double costPerKm, double costPerMin, double minimumFarePerRide) {
        this.costPerKm = costPerKm;
        this.costPerMin = costPerMin;
        this.minimumFarePerRide = minimumFarePerRide;
    }

    /**
     * Purpose : To calculate the minimum fare.
     *
     * @param ride : takes multiple rides.
     * @return : the total fare or minimum fare.
     */
    public double calculateCostOfRide(Ride ride) {
        double rideCost = ride.distance * costPerKm + ride.time * costPerMin;
        return Math.max(rideCost, minimumFarePerRide);
    }
}