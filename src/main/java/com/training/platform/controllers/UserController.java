package com.training.platform.controllers;

import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import com.training.platform.entities.User;
import com.training.platform.repositories.UserRepository;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/demo1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public List<User> index() {
        // Change from UserRepository to UserService
        return userService.findAllByJpqlParamsQuery(0, "bangkok");
    }
    // Example for findAllByJpqlQuery
    @GetMapping(value = "/findAllByJQ")
    public List<User> findAllByJQ() {
        return userService.findAllByJpqlQuery();
    }

    // Example for findAllByParamsQuery
    @GetMapping(value = "/findAllByPQ")
    public List<User> findAllByPQ() {
        return userService.findAllByParamsQuery(0, "nakornpathom");
    }

    // Example for findAllByQuery
    @GetMapping(value = "/findAllByQuery")
    public List<User> findAllByQuery() { return userService.findAllByQuery();
    }
    // Example for findAll
    @GetMapping(value = "/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    // Example for findByAgeIn
    @GetMapping(value = "/findByAgeIn")
    public List<User> getAgeByParam(@RequestParam(name = "age")  List<Integer> listAge) {
        return userService.findByAgeIn(listAge);}

    // Example for findById
    @GetMapping(value = "/findById")
    public Optional<User> findById() {
        return userService.findById(5);
    }

    // Example for findByName
    @GetMapping(value = "/findByName")
    public Optional<User> findByName() {
        return userService.findByName("user5");
    }

    // Example for findAllByActiveAndAge
    @GetMapping(value = "/findAllByActiveAndAge")
    public List<User> findAllByActiveAndAge() {
        return userService.findAllByActiveAndAge();
    }

}
