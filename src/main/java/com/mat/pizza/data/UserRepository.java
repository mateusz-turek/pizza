package com.mat.pizza.data;

import com.mat.pizza.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    User findUserByName (String name);
}
