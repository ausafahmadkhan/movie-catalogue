package com.example.moviecatalogue.Service;

import com.example.moviecatalogue.persistence.Model.CatalogueItem;
import com.example.moviecatalogue.persistence.Model.Movie;
import com.example.moviecatalogue.persistence.Model.MovieResponse;
import com.example.moviecatalogue.persistence.Model.RatingResponse;
import com.example.moviecatalogue.persistence.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service(value = "connect")
public class MovieDetails {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private MovieRepository movieRepository;

    public CatalogueItem getMovieDetails(String userName, String movieName)
    {
        MovieResponse movieResponse = restTemplate.getForObject("http://MOVIE-INFO-APPLICATION/movie/getMovie/" + movieName, MovieResponse.class);
        RatingResponse ratingResponse = restTemplate.getForObject("http://RATING-INFO-APPLICATION/rating/getMovieRating/" + movieName, RatingResponse.class);
        CatalogueItem catalogueItem = new CatalogueItem(userName, movieResponse, ratingResponse);
        return catalogueItem;
    }

    public List<CatalogueItem> getCompleteDetail(Long userId)
    {
        List<Movie> movies = movieRepository.findByUserUserId(userId);
        List<CatalogueItem> catalogueItems = new ArrayList<>();
        for(Movie movie : movies)
        {
            catalogueItems.add(getMovieDetails(movie.getUser().getUserName(),movie.getMovieName()));
        }
        return catalogueItems;
    }
}
