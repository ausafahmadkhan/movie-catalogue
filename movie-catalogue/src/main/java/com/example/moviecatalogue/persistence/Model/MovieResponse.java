package com.example.moviecatalogue.persistence.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class MovieResponse {


    private String name;

    private String desc;


    public MovieResponse()
    {

    }
    public MovieResponse(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
