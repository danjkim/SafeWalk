package com.sanpo.sanpo.Controller;

import com.sanpo.sanpo.Model.User;
import com.sanpo.sanpo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    UserRepository repo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User signup(@RequestBody User user) {
        if (repo.findByEmail(user.getEmail()) != null) {
            return null;
        }
        if (!user.getEmail().matches("[A-Za-z]+@berkeley.edu")) {
            return null; //should set response status to fail
        }
        user.setId(UUID.randomUUID().toString());
        return repo.save(user);
    }
}
