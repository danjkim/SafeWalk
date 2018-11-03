package com.sanpo.sanpo.Repository;

import com.sanpo.sanpo.Model.Example;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExampleRepository extends CrudRepository<Example, String> {
    List<Example> findByAge(int age);
}