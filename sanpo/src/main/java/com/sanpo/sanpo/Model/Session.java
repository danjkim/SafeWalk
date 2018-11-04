package com.sanpo.sanpo.Model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Session {

    @Id
    private String id;
    private String startTime;
    private List<User> users = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public List<User> getUsers() {
        return this.users;
    }

}
