package com.example.moviecatalogue.persistence.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class RatingResponse {

    private String name;

    private int rating;

    public RatingResponse() {
    }

    public RatingResponse(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
