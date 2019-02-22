package com.example.moviecatalogue.persistence.Repository;

import com.example.moviecatalogue.persistence.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
