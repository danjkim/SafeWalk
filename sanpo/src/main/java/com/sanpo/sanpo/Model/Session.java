package com.sanpo.sanpo.Model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Session {

    @Id
    private String id;
    private String startTime;
    private List<String> batchesId;

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

    public List<String> getBatchesId() {
        return batchesId;
    }

    public void setBatchesId(List<String> batchesId) {
        this.batchesId = batchesId;
    }
}
