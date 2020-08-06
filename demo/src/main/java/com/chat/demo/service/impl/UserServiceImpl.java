package com.chat.demo.service.impl;

import com.chat.demo.entity.Role;
import com.chat.demo.entity.User;
import com.chat.demo.repository.UserRepository;
import com.chat.demo.service.UserService;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.*;
import java.util.Collections;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User saveUser(User userFF) {
        User checkUser = userRepository.findByUsername(userFF.getUsername());
        if (checkUser != null) {
            return null;
        } else {
            ClientHttpRequestFactory requestFactory = new
                    HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
            RestTemplate restTemplate = new RestTemplate(requestFactory);

            User user = new User();
            user.setUsername(userFF.getUsername());

            user.setPassword(passwordEncoder.encode(userFF.getPassword()));
            user.setRoles(Collections.singleton(Role.USER));
            User userDb= userRepository.save(user);
            return user;
        }
    }



    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public User AuthUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        try{
        if (passwordEncoder.matches(user.getPassword(), userFromDB.getPassword())) {

            return userFromDB;
        } else {
            return null;
        }}catch (NullPointerException e) {
        return  null;}
    }

    @Override
    public void logout(long id) {

    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }


}
