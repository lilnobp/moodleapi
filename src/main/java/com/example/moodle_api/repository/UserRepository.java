package com.example.moodle_api.repository;

import com.example.moodle_api.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
