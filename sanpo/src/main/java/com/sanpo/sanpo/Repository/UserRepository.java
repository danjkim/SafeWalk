package com.sanpo.sanpo.Repository;

import com.sanpo.sanpo.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findByUsername(String username);
}
