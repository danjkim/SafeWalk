package com.sanpo.sanpo.Controller;

import com.sanpo.sanpo.Model.Example;
import com.sanpo.sanpo.Model.Session;
import com.sanpo.sanpo.Repository.ExampleRepository;
import com.sanpo.sanpo.Repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    SessionRepository repo;

    @GetMapping
    public List<Session> getAll () {
        return null;
    }

    @GetMapping("/{sessionId}")
    public Session findOne(@PathVariable("sessionId") String sessionId) {
        return null;
    }
}
