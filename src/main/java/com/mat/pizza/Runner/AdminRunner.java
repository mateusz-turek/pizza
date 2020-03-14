package com.mat.pizza.Runner;

import com.mat.pizza.Model.Admin;
import com.mat.pizza.data.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminRunner implements ApplicationRunner {

    private AdminRepository adminRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AdminRunner(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (adminRepository.count()==0){
            adminRepository.save(admin(passwordEncoder));
        }
    }
    private Admin admin(PasswordEncoder encoder){
        return new Admin("admin",encoder.encode("admin"));
    }
}
