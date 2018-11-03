package com.sanpo.sanpo.Controller;

import com.sanpo.sanpo.Model.Example;
import com.sanpo.sanpo.Repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/example")
public class ExampleController {

    @Autowired
    ExampleRepository repo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Example postOne (@RequestBody Example example) {
//        repo.deleteAll();
        example.setId(UUID.randomUUID().toString());
        return repo.save(example);
    }

    @GetMapping("/{id}")
    public Example findOne(@PathVariable("id") String id) {
        return repo.findById(id).get();
    }
}
