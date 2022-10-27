package com.issues.issue;

import com.issues.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class IssueServiceImpl implements IssueService {
    UserRepository repository;
    private static Map<Long, Issue> issueRepo = new HashMap<>();
    static {
        Issue issue = new Issue();
        issue.setId(1l);
        issue.setName("Koko");
        issueRepo.put(issue.getId(), issue);

        Issue almond = new Issue();
        almond.setId(2l);
        almond.setName("Almond");
        issueRepo.put(almond.getId(), almond);
    }
    @Override
    public void createIssue(Issue issue) {
        issueRepo.put(issue.getId(), issue);
    }
    @Override
    public void updateIssue(Long id, Issue issue) {
        issueRepo.remove(id);
        issue.setId(id);
        issueRepo.put(id, issue);
    }
    @Override
    public void deleteIssue(Long id) {
        issueRepo.remove(id);

    }
    @Override
    public Collection<Issue> getIssues() {
        return issueRepo.values();
    }
}