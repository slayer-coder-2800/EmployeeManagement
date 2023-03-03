package com.employeemanagement.employeemanagement.controllers;

import com.employeemanagement.employeemanagement.entities.User;
import com.employeemanagement.employeemanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    public UserRepository userRepository;

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return (List<User>) userRepository.findAll();
    }
    @GetMapping("/users/{id}")
    public Optional<User> findById(@PathVariable(value="id") long id){
        return userRepository.findById(id);
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user)
    {
        return userRepository.save(user);
    }
    
    @PostMapping("/users/salarydetails/more/{value}")
    public List<String> more(@RequestBody int value){
        List<User> l= (List<User>) userRepository.findAll();
        List<String> names=new ArrayList<String>();
        for (User u:
             l) {
            if(u.getSalary()>=value)
            {
                names.add(u.getName());
            }
        }
        return names;
    }
}
