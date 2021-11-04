package com.invoice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator = null;

    @BeforeEach
    void setUp()  {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    void givenDistanceAndTime_ShouldReturn_TotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25, 0.0, fare);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5, fare, 0.0);
    }
}