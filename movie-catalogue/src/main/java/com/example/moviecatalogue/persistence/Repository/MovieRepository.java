package com.example.moviecatalogue.persistence.Repository;

import com.example.moviecatalogue.persistence.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    public List<Movie> findByUserUserId(Long userId);

}
