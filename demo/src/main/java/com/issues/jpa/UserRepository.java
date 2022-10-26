package com.issues.jpa;

import java.util.List;
import com.issues.models.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long> {

    List<UserModel> findByName(String name);
    UserModel findById(long id);
}