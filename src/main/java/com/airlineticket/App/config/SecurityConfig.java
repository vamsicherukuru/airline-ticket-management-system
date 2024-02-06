package com.airlineticket.App.config;


import com.airlineticket.App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Autowired
    private UserService userService;

    private final String[] WHITE_LIST_ENDPOINTS = {
            "/login/**",
            "/register/**",
            "/save/user/**", // Add this line
            "/",
            "/api/users",
            "/assets/**",
//            "/booking/**"  //should not be whitelisted
    };

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth-> auth
                                .requestMatchers(WHITE_LIST_ENDPOINTS).permitAll()
                                .requestMatchers("/staff/**").hasAnyAuthority("FLIGHT_OPERATIONS_MANAGER", "ADMIN")
                                .requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
                                .requestMatchers("/profile/**").authenticated()
                                .anyRequest().authenticated()
                        )
                .formLogin(login->
                        login.loginPage("/login")
                )
                .logout(logout->logout.permitAll())
                .httpBasic(Customizer.withDefaults())
                .userDetailsService(userService)
                .build();
    }



    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
