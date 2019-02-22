package com.example.movieinfo.Service;

import com.example.movieinfo.Persistence.Model.Movie;

public interface IMovieService {

    public Movie getMovie(String name);

    public void addMovie(Movie movie);
}
