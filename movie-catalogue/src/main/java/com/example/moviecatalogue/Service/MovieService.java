package com.example.moviecatalogue.Service;

import com.example.moviecatalogue.persistence.Model.Movie;
import com.example.moviecatalogue.persistence.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie getMovie(Long id)
    {
        Movie movie = movieRepository.findById(id).orElse(null);
        return  movie;

    }

    @Override
    public List<Movie> findByUserId(Long userId)
    {
        List<Movie> movies = movieRepository.findByUserUserId(userId);
        return movies;
    }

    @Override
    public void addMovie(Movie movie)
    {
        movieRepository.saveAndFlush(movie);
    }
}
