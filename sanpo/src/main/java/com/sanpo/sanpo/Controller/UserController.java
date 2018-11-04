package com.sanpo.sanpo.Controller;

import com.sanpo.sanpo.Model.User;
import com.sanpo.sanpo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
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


    @GetMapping()
    public List<User> getAll() {
        return (List<User>) repo.findAll();
    }

    @GetMapping("/{email}")
    public User getOne(@PathVariable("email") String email) {
        return repo.findByEmail(email);
    }
}
