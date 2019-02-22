package com.example.ratinginfo.Persistence.Repository;

import com.example.ratinginfo.Persistence.Model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, String> {
}
