package com.mat.pizza.Service;

import com.mat.pizza.Model.User;
import com.mat.pizza.data.UserRepositoryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRepoServiceImplementation implements UserDetailsService {

    private UserRepositoryImplementation userRepositoryImplementation;

    @Autowired
    public UserRepoServiceImplementation(UserRepositoryImplementation userRepositoryImplementation) {
        this.userRepositoryImplementation = userRepositoryImplementation;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepositoryImplementation.findUserByName(userName);
        if (user != null){
            return user;
        }
        else throw new UsernameNotFoundException("Can not find user");
    }
}
