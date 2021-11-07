package com.invoice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    InvoiceService invoiceService = null;

    @BeforeEach
    void setUp() throws Exception {
        invoiceService = new InvoiceService();
    }


    @Test
    void givenDistanceAndTime_ShouldReturn_TotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assertions.assertEquals(25, 0.0, fare);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time);
        Assertions.assertEquals(5, fare, 0.0);
    }

    //    @Test
//    void givenMultipleRides_ShouldReturn_TotalFare() {
//        Ride[] rides = {
//                new Ride(2.0, 5),
//                new Ride(0.1, 1)
//        };
//        double fare = invoiceGenerator.calculateFare(rides);
//        Assertions.assertEquals(30, fare, 0.0);
//    }
    @Test
    void givenMultipleRides_ShouldReturn_InvoiceSummary() {
        Ride[] rides = {
                new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.NORMAL, 0.1, 1)
        };
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedinvoiceSummary = new InvoiceSummary(2, 30);
        Assertions.assertEquals(expectedinvoiceSummary, summary);
    }

    @Test
    void givenUserIDAndRides_ShouldReturn_InvoiceSummary() {
        String userId = "v@r.com";
        Ride[] rides = {
                new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.NORMAL, 0.1, 1)
        };
        Ride[] rides1 = {
                new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.NORMAL, 0.1, 1)
        };
        invoiceService.addRide(userId, rides1);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedinvoiceSummary = new InvoiceSummary(2, 30);
        Assertions.assertEquals(expectedinvoiceSummary, summary);
    }

    @Test
    void givenUserIDAndRideList_WhenFareCalculatedForNormalRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.NORMAL, 0.1, 1),
                new Ride(CabRide.NORMAL, 1.0, 5)
        };
        String userId = "CRN 1002";
        invoiceService.addRide(userId, rides);
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 45.0);
        Assertions.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
}
