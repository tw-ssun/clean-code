package com.thoughtworks.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {
    public double getTotalRental(){
        return this.stream().mapToDouble(Rental::calculateRentalAmount).sum();
    }

    public int getFrequentRenterPoint(){
        return this.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }

    public ArrayList<MovieRentalItem> getMovieRentalItems(){
        return (ArrayList<MovieRentalItem>) this.stream().map(rent -> new MovieRentalItem(
                rent.getMovie().getTitle(),
                rent.calculateRentalAmount()
            )
        );
    }
}
