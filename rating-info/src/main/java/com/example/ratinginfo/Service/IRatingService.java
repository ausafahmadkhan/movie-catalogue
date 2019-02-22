package com.example.ratinginfo.Service;

import com.example.ratinginfo.Persistence.Model.Rating;

public interface IRatingService  {

    public Rating getRating(String name);

    public void addRating(Rating rating);
}
