package com.mat.pizza.Service;

import com.mat.pizza.Model.Admin;
import com.mat.pizza.data.AdminRepository;
import com.mat.pizza.data.AdminRepositoryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements UserDetailsService {

    private AdminRepositoryImplementation adminRepositoryImplementation;

    @Autowired
    public AdminService(AdminRepositoryImplementation adminRepositoryImplementation) {
        this.adminRepositoryImplementation = adminRepositoryImplementation;
    }

    @Override
    public UserDetails loadUserByUsername(String adminName) throws UsernameNotFoundException {
        Admin admin = adminRepositoryImplementation.findAdminByName(adminName);
        if (admin!=null){
            return admin;
        }
        else throw new UsernameNotFoundException("cant find admin");
    }
}
