package com.example.ratinginfo.Controller;


import com.example.ratinginfo.Persistence.Model.Rating;
import com.example.ratinginfo.Service.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class MainController {

    @Autowired
    private IRatingService ratingService;


    @RequestMapping(path = "/getMovieRating/{movieName}", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<Rating> getRating(@PathVariable("movieName") String movieName)
    {
        Rating rating = ratingService.getRating(movieName);
        return new ResponseEntity<>(new Rating(rating.getName(), rating.getRating()), HttpStatus.OK);
    }

    @RequestMapping(path = "/addMovieRating", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public  ResponseEntity<String> addRating(@RequestBody Rating rating)
    {
        ratingService.addRating(rating);
        return new ResponseEntity<>(new String("Added Rating"), HttpStatus.OK);
    }
}
