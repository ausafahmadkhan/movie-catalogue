package com.example.ratinginfo.Service;

import com.example.ratinginfo.Persistence.Model.Rating;
import com.example.ratinginfo.Persistence.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RatingService implements IRatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating getRating(String name)
    {
        Rating rating = ratingRepository.findById(name).orElse(null);
        return rating;
    }

    public void addRating(Rating rating)
    {
        ratingRepository.saveAndFlush(rating);
    }
}
