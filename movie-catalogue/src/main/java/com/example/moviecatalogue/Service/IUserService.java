package com.example.moviecatalogue.Service;

import com.example.moviecatalogue.persistence.Model.User;

import java.util.List;

public interface IUserService  {

    public User getUser(Long id);

    public void addUser(User user);

}
