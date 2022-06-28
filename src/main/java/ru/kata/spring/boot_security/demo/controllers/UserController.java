package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.services.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/admin/showAllUsers")
    public String getAllUsers(Model model) {
        model.addAttribute("user", userService.findAll());
        return "showAllUsers";
    }

    @GetMapping("/admin/add")
    public String addUserForm(User user) {
        return "add";
    }

    @PostMapping("/admin/add")
    public String addUser(User user) {
        userService.saveUser(user);
        return "redirect:/showAllUsers";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/showAllUsers";
    }
    @GetMapping("/admin/update/{id}")
    public String updateUserForm(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/update";
    }

    @PostMapping("/admin/update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/showAllUsers";
    }





}
