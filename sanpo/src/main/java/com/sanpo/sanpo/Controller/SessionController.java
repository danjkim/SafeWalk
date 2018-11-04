package com.sanpo.sanpo.Controller;

import com.sanpo.sanpo.Model.Session;
import com.sanpo.sanpo.Model.User;
import com.sanpo.sanpo.Repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    SessionRepository repo;

    @GetMapping
    public List<Session> getAll () {
        List<Session> result = new ArrayList<>();
        for (Session s: repo.findAll()) {
            result.add(s);
        }
        return result;
    }

    @GetMapping("/{sessionId}")
    public Session findOne(@PathVariable("sessionId") String sessionId) {
        Session s = repo.findById(sessionId).get();
        return s;
    }

    @PostMapping
    public Session addSession() {
        Session s = new Session();
        s.setId("Downtown");
        s.setStartTime("8:00PM");
        return repo.save(s);
    }


    @PutMapping("/{sessionId}")
    public Session addUser(@PathVariable("sessionId") String sessionId, @RequestBody User user) {
        Session s = repo.findById(sessionId).get();
        s.getUsers().add(user);
        return repo.save(s);

    }
}
