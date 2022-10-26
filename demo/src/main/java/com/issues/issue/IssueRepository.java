package com.issues.issue;
import com.issues.issue.IssueModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IssueRepository extends CrudRepository<IssueModel, Long> {

    List<IssueModel> findByName(String name);
    IssueModel findById(long id);
}