package com.invoice;

public class InvoiceSummary {

    private final int numberOfRides;
    private final double totalFare;
    private final double average;

    /**
     * Purpose : Given distance and time for multiple rides,
     * Calculate aggregate total fare for all the journey
     * Calculate the average fare per ride taking total number of rides and total fare as input
     *
     * @param numberOfRides : Takes number of rides
     * @param totalFare     : Takes Total Fare
     */
    public InvoiceSummary(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.average = this.totalFare / this.numberOfRides;
    }

    /**
     * @param o : takes Object Class.
     * @return : number of Rides.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numberOfRides == that.numberOfRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.average, average) == 0;
    }

}
