package com.thoughtworks.movierental;

import java.util.ArrayList;

public class StatementGenerator {

    String customerName;
    ArrayList<MovieRentalItem> movieRentals;
    double totalRental;
    int totalFreqRenterPoint;

    private StatementGenerator(String customerName,
                              ArrayList<MovieRentalItem> movieRentals,
                              double totalRental,
                              int totalFreqRenterPoint){
        this.customerName = customerName;
        this.movieRentals = movieRentals;
        this.totalRental = totalRental;
        this.totalFreqRenterPoint = totalFreqRenterPoint;
    }

    public static StatementGenerator factory(Customer customer, Rentals rentals){
        String customerName = customer.getName();
        double totalRental = rentals.getTotalRental();
        ArrayList<MovieRentalItem> movieRentalItems = rentals.getMovieRentalItems();
        int totalFreqRenterPoint = rentals.getFrequentRenterPoint();

        return new StatementGenerator(customerName, movieRentalItems, totalRental, totalFreqRenterPoint);
    }

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
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("<h1>Rental Record for <b>%s</b></h1>", this.customerName));
        sb.append("<p>");
        for(MovieRentalItem rentItem : this.movieRentals){
            sb.append(String.format("%s: <b>%s</b><br/>",
                    rentItem.movieName,
                    rentItem.rentalAmount.toString()));
        }
        sb.append("</p>");
        sb.append(String.format("<p>Amount owed is <b> %s</b></p></br>",this.totalRental));
        sb.append(String.format("<p>You earned <b>%s</b> frequent renter points </p></br>", this.totalFreqRenterPoint));
        return sb.toString();
    }
}
