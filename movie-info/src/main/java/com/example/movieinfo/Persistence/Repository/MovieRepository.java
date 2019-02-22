package com.example.movieinfo.Persistence.Repository;

import com.example.movieinfo.Persistence.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {
}
