package com.mat.pizza.data;

import com.mat.pizza.Model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImplementation {

    private UserRepository userRepository;

    public UserRepositoryImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByName(String name){
       return userRepository.findUserByName(name);
    }

    public void save (User user){
        userRepository.save(user);
    }
}
