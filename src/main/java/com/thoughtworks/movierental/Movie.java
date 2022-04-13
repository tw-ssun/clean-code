package com.thoughtworks.movierental;

public class Movie {

    private String title;
    private MovieType movieType;

    public Movie(String title, MovieType movieType) {
        this.title = title;
        this.movieType = movieType;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType type) {
        movieType = type;
    }

    public String getTitle() {
        return title;
    }

}