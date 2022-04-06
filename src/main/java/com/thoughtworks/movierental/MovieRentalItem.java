package com.thoughtworks.movierental;

public class MovieRentalItem{
    public String movieName;
    public Double rentalAmount;
    public MovieRentalItem(String movieName, Double rentalAmount){
        this.movieName = movieName;
        this.rentalAmount = rentalAmount;
    }
}