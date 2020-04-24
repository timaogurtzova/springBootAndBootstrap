package com.hellocat.springBootAndBootstrap.repository;

import com.hellocat.springBootAndBootstrap.domen.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByName(String name);

}

