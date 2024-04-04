package com.example.moodle_api.service;
import com.example.moodle_api.model.User;
import com.example.moodle_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return (List<User>) userRepository.findAll();
    }
    public Optional<User> getUserById (long userId){
        return userRepository.findById(userId);
    }

}
