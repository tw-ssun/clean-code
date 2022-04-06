package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    @Test
    public void testStatementGenerationWORentals() {
        Customer customer = new Customer("testname");
        String expected = "Rental Record for testname\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";
        String statement = customer.textStatement();
        Assert.assertEquals(expected, statement);
    }

    @Test
    public void testStatementGenerationWithRentals() {
        Customer customer = new Customer("testname");
        customer.addRental(new Rental(
                new Movie("boring movie", 1),
                2
        ));
        customer.addRental(new Rental(
                new Movie("boring movie 2", 2),
                2
        ));
        customer.addRental(new Rental(
                new Movie("boring movie 3", 3),
                2
        ));
        String expected = "Rental Record for testname\n" +
                "\tboring movie\t6.0\n" +
                "\tboring movie 2\t1.5\n" +
                "\tboring movie 3\t0.0\n" +
                "Amount owed is 7.5\n" +
                "You earned 4 frequent renter points";
        String statement = customer.textStatement();
        Assert.assertEquals(expected, statement);
    }
}