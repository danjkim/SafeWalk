package com.sanpo.sanpo.Controller;

import com.sanpo.sanpo.Model.Batch;
import com.sanpo.sanpo.Model.Example;
import com.sanpo.sanpo.Repository.BatchRepository;
import com.sanpo.sanpo.Repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/batches")
public class BatchController {

    @Autowired
    BatchRepository repo;

    @GetMapping
    public List<Batch> getAll () {
        return null;
    }

    @GetMapping("/{batchId}")
    public Batch findOne(@PathVariable("batchId") String batchId) {
        return null;
    }

    @PutMapping("/{batchId}")
    public Batch modifyBatch(@PathVariable("batchId") String batchId, @RequestBody Batch batch) {
        return null;
    }
}
