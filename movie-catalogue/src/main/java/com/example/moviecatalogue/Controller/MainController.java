package com.example.moviecatalogue.Controller;


import com.example.moviecatalogue.Service.IMovieService;
import com.example.moviecatalogue.Service.IUserService;
import com.example.moviecatalogue.Service.MovieDetails;
import com.example.moviecatalogue.persistence.Model.CatalogueItem;
import com.example.moviecatalogue.persistence.Model.Movie;
import com.example.moviecatalogue.persistence.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movie-catalogue")
public class MainController {

    @Autowired
    private IMovieService movieService;

    @Autowired
    private IUserService userService;

    @Autowired
    @Qualifier(value = "connect")
    private MovieDetails movieDetails;


    @RequestMapping(path = "/getMovie/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<Movie> getMovie(@PathVariable("id") Long id)
    {
        Movie movie = movieService.getMovie(id);
        return  new ResponseEntity<>(new Movie(movie.getMovieId(), movie.getMovieName()), HttpStatus.OK);
    }

    @RequestMapping(path = "/getMoviePerUser/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<List<Movie>> getMoviePerUser(@PathVariable("id") Long id)
    {
        List<Movie> movies = movieService.findByUserId(id);
        return  new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @RequestMapping(path = "/addMovie/{userId}", method = RequestMethod.POST,consumes = {"application/json"},produces = {"application/json"})
    public ResponseEntity<String> addMovie( @PathVariable("userId") Long userId, @RequestBody Movie movie)
    {
        movie.setUser(userService.getUser(userId));
        movieService.addMovie(movie);
        return new ResponseEntity<>("Added",HttpStatus.OK);
    }


    @RequestMapping(path = "/addUser", method = RequestMethod.POST,consumes = {"application/json"},produces = {"application/json"})
    public ResponseEntity<String> addUser(@RequestBody User user)
    {
        userService.addUser(user);
        return new ResponseEntity<>("Added", HttpStatus.OK);
    }


    @RequestMapping(path = "/getUser/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<User> getUser(@PathVariable("id") Long id)
    {
        User user = userService.getUser(id);
        return  new ResponseEntity<>(new User(user.getUserId(),user.getUserName()), HttpStatus.OK);
    }


    @RequestMapping(value = "/getFullDetail/{userId}", method = RequestMethod.GET,produces = {"application/json"})
    public ResponseEntity<List<CatalogueItem>> getDetails(@PathVariable("userId") Long userId)
    {
        List<CatalogueItem> catalogueItems = movieDetails.getCompleteDetail(userId);
        return new ResponseEntity<List<CatalogueItem>>(catalogueItems, HttpStatus.OK);
    }

}
