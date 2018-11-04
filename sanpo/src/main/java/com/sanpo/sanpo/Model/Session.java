package com.sanpo.sanpo.Model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Session {

    @Id
    private String id;
    private String startTime;
    private String destinationName;
    private List<User> users = new ArrayList<>();

    public String getId() {
        return id;
    }

    public String getDestinationName() { return destinationName; }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
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

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
