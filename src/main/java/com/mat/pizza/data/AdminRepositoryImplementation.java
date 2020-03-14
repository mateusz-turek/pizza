package com.mat.pizza.data;

import com.mat.pizza.Model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepositoryImplementation {


    private AdminRepository adminRepository;

    @Autowired
    public AdminRepositoryImplementation(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin findAdminByName(String adminName){
        return adminRepository.findAdminByName(adminName);
    }
}
