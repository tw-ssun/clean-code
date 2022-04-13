package com.thoughtworks.movierental;

import static com.thoughtworks.movierental.MovieType.BLUERAY;
import static com.thoughtworks.movierental.MovieType.NEW_RELEASE;

public class Rental {

    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double calculateRentalAmount(){
        double amount = 0;

        switch (getMovie().getMovieType()) {
            case REGULAR:
                amount += 2;
                if (getDaysRented() > 2)
                    amount += (getDaysRented() - 2) * 1.5;
                break;
            case NEW_RELEASE:
                amount += getDaysRented() * 3;
                break;
            case CHILDRENS:
                amount += 1.5;
                if (getDaysRented() > 3)
                    amount += (getDaysRented() - 3) * 1.5;
                break;
            case BLUERAY:
                amount = 4 * daysRented;
        }
        return amount;
    }

    public int getFrequentRenterPoints() {
        if (getMovie().getMovieType() == BLUERAY) return 3;
        if ((getMovie().getMovieType() == NEW_RELEASE)
                &&
                getDaysRented() > 1)
            return 2;
        return 1;
    }
}