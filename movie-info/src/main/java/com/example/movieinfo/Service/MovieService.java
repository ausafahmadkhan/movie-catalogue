package com.example.movieinfo.Service;

import com.example.movieinfo.Persistence.Model.Movie;
import com.example.movieinfo.Persistence.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie getMovie(String name)
    {
        Movie movie = movieRepository.findById(name).orElse(null);
        return movie;
    }

    public void addMovie(Movie movie)
    {
        movieRepository.saveAndFlush(movie);
    }
}
