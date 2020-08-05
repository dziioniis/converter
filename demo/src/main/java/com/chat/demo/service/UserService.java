package com.chat.demo.service;

import com.chat.demo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService extends UserDetailsService {
    Iterable<User> getAll();
    User getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    User AuthUser(User user);
    void logout(long id);

}
