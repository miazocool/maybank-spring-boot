package com.issues.issue;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IssueRepository extends CrudRepository<Issue, Long> {

    List<Issue> findByName(String name);
    Issue findById(long id);
    List<Issue> findByUserId(long userId);
}