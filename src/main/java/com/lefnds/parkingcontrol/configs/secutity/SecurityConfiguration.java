package com.lefnds.parkingcontrol.configs.secutity;

import org.apache.catalina.UserDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests().anyRequest().permitAll()
                .and()
                .csrf().disable();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails userDetails = User.builder()
                .username("LEDU")
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

// DEPRECATED

//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .httpBasic()
//                .and()
//                .authorizeHttpRequests()
//                .anyRequest().permitAll();
//                .and()
//                .crsf().disable();
//    }
//}
