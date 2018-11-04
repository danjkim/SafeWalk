package com.sanpo.sanpo.Model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Region {

    @Id
    private String id;
    private List<Session> sessions = new ArrayList<>();

    public String getId() {
        return this.id;
    }
    public List<Session> getSessions() {
        return this.sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
}
