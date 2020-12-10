package com.mercury.final_server.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.final_server.bean.User;
import com.mercury.final_server.dao.UserDao;
import com.mercury.final_server.http.Response;
import com.mercury.final_server.service.UserService;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable("id") int id){
        return userService.getOneUser(id);
    }

    @PostMapping
    public Response addUser(@Valid @RequestBody User user) {
        return userService.register(user);
    }

//    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
//    @PutMapping
//    public Response toggleDisable(@RequestBody User user) {
//        return userService.toggleDisable(user);
//    }

//    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
//    @PutMapping("/{id}")
//    public Response changeUser(@RequestBody User user, Authentication authentication) {
//        return userService.changePassword(user, authentication);
//    }

//    @DeleteMapping("/{id}")
//    public Response deleteUser(@PathVariable int id) {
//        return userService.deleteUser(id);
//    }

}
