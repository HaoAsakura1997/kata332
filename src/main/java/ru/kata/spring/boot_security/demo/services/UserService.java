package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    public User findById(Long id);

    public List<User> findAll();

    public User saveUser(User user, PasswordEncoder passwordEncoder);

    public void deleteById(Long id);

    public UserDetails loadUserByUsername(String string);

    public User findByUsername(String username);

    public User updateUser (User user, PasswordEncoder passwordEncoder);
}
