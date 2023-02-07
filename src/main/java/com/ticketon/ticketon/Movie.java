package com.ticketon.ticketon;

public class Movie {
    public int id;
    public String movieTittle;
    public String moviePath;
    public Double movieRating;
    public String movieDescription;
    public Double movieCost;

    public Movie(int id, String movieTittle, String moviePath, Double movieRating, String movieDescription, Double movieCost) {
        this.id = id;
        this.movieTittle = movieTittle;
        this.moviePath = moviePath;
        this.movieRating = movieRating;
        this.movieDescription = movieDescription;
        this.movieCost = movieCost;
    }


}
