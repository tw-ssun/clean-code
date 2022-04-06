package com.thoughtworks.movierental;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class StatementGenerator {

    String customerName;
    ArrayList<MovieRentalItem> movieRentals;
    double totalRental;
    int totalFreqRenterPoint;

    public static StatementGenerator factory(Customer customer){
        String customerName = customer.getName();
        ArrayList<MovieRentalItem> movieRentals = new ArrayList<>();
        double totalRental = 0;
        int totalFreqRenterPoint = 0;

        for(Rental rental : customer.getRentals()) {
            totalRental += rental.calculateRentalAmount();
            totalFreqRenterPoint += rental.getFrequentRenterPoints();
            movieRentals.add(new MovieRentalItem(
               rental.getMovie().getTitle(),
               rental.calculateRentalAmount()
            ));
        }

        return new StatementGenerator(customerName,
                movieRentals,
                totalRental,
                totalFreqRenterPoint);
    }

    private StatementGenerator(String customerName,
                              ArrayList<MovieRentalItem> movieRentals,
                              double totalRental,
                              int totalFreqRenterPoint){
        this.customerName = customerName;
        this.movieRentals = movieRentals;
        this.totalRental = totalRental;
        this.totalFreqRenterPoint = totalFreqRenterPoint;
    }

    public String generateTextStatement(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Rental Record for %s\n", this.customerName));
        for(MovieRentalItem rentItem : this.movieRentals){
            sb.append(String.format("\t%s\t%s\n",
                    rentItem.movieName,
                    rentItem.rentalAmount.toString()));
        }
        sb.append(String.format("Amount owed is %s\n", this.totalRental));
        sb.append(String.format("You earned %s frequent renter points", this.totalFreqRenterPoint));

        return sb.toString();
    }

    public String generateHtmlStatement(){
        throw new NotImplementedException();
    }
}
