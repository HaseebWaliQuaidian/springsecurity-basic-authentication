package com.haseeb.springsecuritybasicauthentication.repo;

import com.haseeb.springsecuritybasicauthentication.controllers.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
