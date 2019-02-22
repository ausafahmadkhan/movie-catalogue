package com.example.moviecatalogue.persistence.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Id
    private Long userId;

    @Column
    private String userName;
    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}

