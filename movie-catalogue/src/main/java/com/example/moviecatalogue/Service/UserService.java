package com.example.moviecatalogue.Service;

import com.example.moviecatalogue.persistence.Model.User;
import com.example.moviecatalogue.persistence.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User getUser(Long id)
    {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    @Override
    public void addUser(User user)
    {
        userRepository.saveAndFlush(user);
    }

}
