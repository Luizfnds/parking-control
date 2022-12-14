package com.lefnds.parkingcontrol.configs.secutity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests().anyRequest().permitAll();
                .and()
                .csrf().disable();
        return http.build();
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
