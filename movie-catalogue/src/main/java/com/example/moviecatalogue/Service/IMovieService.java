package com.example.moviecatalogue.Service;

import com.example.moviecatalogue.persistence.Model.Movie;

import java.util.List;

public interface IMovieService {


    public List<Movie> findByUserId(Long userId);
    public Movie getMovie(Long id);
    public void addMovie(Movie movie);
}
