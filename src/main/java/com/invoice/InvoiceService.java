package com.invoice;

/**
 * Purpose : To implement Cab Service.
 *
 * @author VAISHNAVI R VISHWAKARMA
 * @since 2021-11-04
 */
public class InvoiceService {

    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10.0;
    private static final double MINIMUM_FARE = 5;
    private RideRepository rideRepository;

    public InvoiceService() {
        this.rideRepository = new RideRepository();
    }

    /**
     * Purpose : To calculate the minimum fare.
     *
     * @param distance : takes the distance.
     * @param time     : takes the time.
     * @return total fare or minimum fare.
     */
    public double calculateFare(double distance, int time) {

        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    /**
     * Purpose : Given distance and time for multiple rides,
     * Return aggregate total fare for all the journey.
     *
     * @param rides : takes multiple rides
     * @return total fare.
     */
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare += ride.cabRide.calculateCostOfRide(ride);
//            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRide(String userId, Ride[] rides) {
        rideRepository.addRide(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
}
