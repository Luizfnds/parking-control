package com.lefnds.parkingcontrol.configs.secutity;


import com.lefnds.parkingcontrol.models.UserModel;
import com.lefnds.parkingcontrol.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = repository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found with username: " + username));
        return new User(userModel.getUsername(), userModel.getPassword(), true, true, true, true, userModel.getAuthorities());
    }
}
