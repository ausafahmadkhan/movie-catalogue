package com.example.moviecatalogue.persistence.Model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {


    @Id
    private Long movieId;

    @Column
    private String movieName;

    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Movie() {
    }

    public Movie(Long movieId, String movieName) {
        this.movieId = movieId;
        this.movieName = movieName;
    }
}
