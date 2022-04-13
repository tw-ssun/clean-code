package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class RentalTest {
    @Test
    public void testRentalAmountForBlueRay(){
        Movie blueRayMovie = new Movie("Blue ray movie", MovieType.BLUERAY);
        Rental rental1 = new Rental(blueRayMovie, 1);
        Rental rental2 = new Rental(blueRayMovie, 2);
        double rent1Amount = rental1.calculateRentalAmount();
        double rent2Amount = rental2.calculateRentalAmount();
        Assert.assertEquals(4, rent1Amount, 0);
        Assert.assertEquals(8, rent2Amount, 0);
    }

    @Test
    public void testFrequentRentalPointForBlueRay(){
        Movie blueRayMovie = new Movie("Blue ray movie", MovieType.BLUERAY);
        Rental rental = new Rental(blueRayMovie, 1);
        Assert.assertEquals(3, rental.getFrequentRenterPoints());
    }
}
