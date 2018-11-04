package com.sanpo.sanpo.Model;

import java.util.ArrayList;
import java.util.List;

public class Region {
    private String id;
    private List<Session> sessions = new ArrayList<>();

    public String getId() {
        return this.id;
    }
    public List<Session> getSessions() {
        return this.sessions;
    }
}
