package com.example.moviecatalogue.persistence.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

public class CatalogueItem {

    private String userName;
    private MovieResponse movieResponse;
    private RatingResponse ratingResponse;

    public CatalogueItem(String userName, MovieResponse movieResponse, RatingResponse ratingResponse) {
        this.userName = userName;
        this.movieResponse = movieResponse;
        this.ratingResponse = ratingResponse;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public MovieResponse getMovieResponse() {
        return movieResponse;
    }

    public void setMovieResponse(MovieResponse movieResponse) {
        this.movieResponse = movieResponse;
    }

    public RatingResponse getRatingResponse() {
        return ratingResponse;
    }

    public void setRatingResponse(RatingResponse ratingResponse) {
        this.ratingResponse = ratingResponse;
    }
}
