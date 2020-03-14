package com.mat.pizza.Web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
public class InMemorySecurityConfig extends WebSecurityConfigurerAdapter {


    @Qualifier("userRepoServiceImplementation")
    @Autowired
    private UserDetailsService userDetailsService;

    @Qualifier("adminService")
    @Autowired
    private UserDetailsService userDetailsService2;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
        auth
                .userDetailsService(userDetailsService2)
                .passwordEncoder(encoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/panel")
                .hasRole("ADMIN")
                .antMatchers("/register")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/pizza")
                .hasRole("USER")
                .anyRequest()
                .hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/auth")
                .usernameParameter("user")
                .passwordParameter("pwd")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/");
    }

    /*  @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .inMemoryAuthentication()
                    .withUser("Andrew")
                    .password("Adams")
                    .authorities("ROLE_USER");
        }

       */
    @Bean
    public PasswordEncoder encoder() {
        return new StandardPasswordEncoder("SampleSecret");
    }
}
