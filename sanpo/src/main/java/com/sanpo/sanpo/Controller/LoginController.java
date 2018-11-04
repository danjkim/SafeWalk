package com.sanpo.sanpo.Controller;

import com.sanpo.sanpo.Model.User;
import com.sanpo.sanpo.Repository.UserRepository;
import org.omg.CORBA.portable.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserRepository repo;


    @PostMapping
    public ResponseEntity<?> login(@RequestBody User user) {
        if (user == null || user.getEmail() == null || repo.findByEmail(user.getEmail()) == null || user.getPassword() == null) {
            return new ResponseEntity(new CustomError("login has bad parameters."), HttpStatus.BAD_REQUEST);
        }
        User curUser = repo.findByEmail(user.getEmail());
        if (user.getPassword().equals(curUser.getPassword())) {
            return new ResponseEntity<User>(curUser, HttpStatus.OK);
        }
        return new ResponseEntity(new CustomError("incorrect password."), HttpStatus.BAD_REQUEST);
    }
}
