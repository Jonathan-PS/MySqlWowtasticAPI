package no.jonathanps.wowtastic.controllers;

import no.jonathanps.wowtastic.jpa.User;
import no.jonathanps.wowtastic.queries.UserQueries;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/user")
    public List<User> usersGet() {
        return UserQueries.getUsers();
    }

    @GetMapping("/user/{userId}")
    public User userGet(@PathVariable int userId) {
        return UserQueries.getUser(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    public User insertNewUser(@RequestBody User newUser) {
        UserQueries.addUser(newUser);
        return newUser;
    }

}
