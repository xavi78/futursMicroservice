package com.geekshubs.auth.domain.repositories;

import com.geekshubs.auth.domain.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    public Optional<User> findByUsername(String UserName);
}
