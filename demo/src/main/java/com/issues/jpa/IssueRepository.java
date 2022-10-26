package com.issues.jpa;

import com.issues.models.IssueModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IssueRepository extends CrudRepository<IssueModel, Long> {

    List<IssueModel> findByName(String name);
    IssueModel findById(long id);
}