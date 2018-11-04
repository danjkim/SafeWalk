package com.sanpo.sanpo.Controller;

import com.sanpo.sanpo.Model.User;
import com.sanpo.sanpo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserRepository repo;

    @GetMapping
    public User login(@RequestBody User user) {
        if (user == null) {
            return null;
        }
        User curUser = repo.findByEmail(user.getEmail());
        if (user.getPassword().equals(curUser.getPassword())) {
            return curUser;
        }
        return null;
    }
}
