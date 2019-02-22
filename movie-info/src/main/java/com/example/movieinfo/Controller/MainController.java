package com.example.movieinfo.Controller;


import com.example.movieinfo.Persistence.Model.Movie;
import com.example.movieinfo.Persistence.Model.MovieResponse;
import com.example.movieinfo.Service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MainController {

    @Autowired
    private IMovieService movieService;

    @RequestMapping(path ="/getMovie/{name}", method = RequestMethod.GET, produces = {"application/json"})
    public MovieResponse getMovie(@PathVariable("name") String name)
    {
        Movie movie = movieService.getMovie(name);
        MovieResponse movieResponse = new MovieResponse(movie.getName(),movie.getDesc());
        return movieResponse;
    }

    @RequestMapping(path = "/addMovie",method = RequestMethod.POST,consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<String> addMovie(@RequestBody Movie movie)
    {
        movieService.addMovie(movie);
        return new ResponseEntity<>("Added Movie", HttpStatus.OK);
    }
}
