package com.sanpo.sanpo.Controller;

import com.sanpo.sanpo.Model.User;
import com.sanpo.sanpo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    UserRepository repo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> signup(@RequestBody User user) {
        if (repo.findByEmail(user.getEmail()) != null) {
            return new ResponseEntity(new CustomError("this email already exists."), HttpStatus.BAD_REQUEST);
        }
        if (!user.getEmail().matches("^[^@]+@berkeley\\.edu")) {
            return new ResponseEntity(new CustomError("Please enter a valid UC Berkeley email (...@berkeley.edu)"), HttpStatus.BAD_REQUEST);
        }
        user.setId(UUID.randomUUID().toString());
        return new ResponseEntity<User>(repo.save(user), HttpStatus.OK);
    }
}