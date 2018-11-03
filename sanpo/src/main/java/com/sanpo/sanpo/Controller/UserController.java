package com.sanpo.sanpo.Controller;

import com.sanpo.sanpo.Model.User;
import com.sanpo.sanpo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository repo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User postOne (@RequestBody User user) {
//        user.setId(UUID.randomUUID().toString());
//        return repo.save(user);
        return null;
    }

    @GetMapping("/{username}")
    public User findOne(@PathVariable("username") String username) {
//        return repo.findByUsername(username);
        return null;
    }
}
