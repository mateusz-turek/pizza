package com.mat.pizza.data;

import com.mat.pizza.Model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin,Long> {

    Admin findAdminByName (String adminName);
}
