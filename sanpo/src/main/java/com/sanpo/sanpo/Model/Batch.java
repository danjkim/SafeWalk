package com.sanpo.sanpo.Model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Batch {
    private enum Hotspots {
        UNIT1, UNIT2, UNIT3, CAMPANILE, FOOTHILL, SATHERGATE
    };

    @Id
    private String id;

    private Hotspots source;
    private Hotspots dest;
    private int numberJoined;
    private List<User> joinedUsers;

    public Hotspots getSource() {
        return source;
    }

    public Hotspots getDest() {
        return dest;
    }

    public int getNumberJoined() {
        return numberJoined;
    }

    public List<User> getJoinedUsers() {
        return joinedUsers;
    }

    public void setSource(Hotspots source) {
        this.source = source;
    }

    public void setDest(Hotspots dest) {
        this.dest = dest;
    }

    public void setNumberJoined(int numberJoined) {
        this.numberJoined = numberJoined;
    }

    public void setJoinedUsers(List<User> joinedUsers) {
        this.joinedUsers = joinedUsers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
