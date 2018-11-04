package com.sanpo.sanpo.Controller;

import com.sanpo.sanpo.Model.Session;
import com.sanpo.sanpo.Model.User;
import com.sanpo.sanpo.Repository.SessionRepository;
import com.sanpo.sanpo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    SessionRepository repo;

    @Autowired
    UserRepository repo1;

    @GetMapping
    public List<Session> getAll () {
        return (List<Session>) repo.findAll();
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
    public Session addUser(@PathVariable("sessionId") String sessionId, @RequestBody String userId) {
        Session s = repo.findById(sessionId).get();
        User user = repo1.findById(userId).get();
        Session old = repo.findById(user.getLastSessionId()).get();
        String[] oldTime = old.getStartTime().split(":");
        String[] currTime = s.getStartTime().split(":");
        int oldTimeVal = 60*Integer.parseInt(oldTime[0]) + Integer.parseInt(oldTime[1]);
        int currTimeVal = 60*Integer.parseInt(currTime[0]) + Integer.parseInt(currTime[1]);
        // delete old session user list user
        if (oldTimeVal >= currTimeVal) {
            old.getUsers().remove(user);
        }
        user.setLastSessionId(sessionId);
        s.getUsers().add(user);
        return repo.save(s);

    }
}
