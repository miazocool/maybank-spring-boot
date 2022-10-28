package com.issues.issue;

import com.issues.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class IssueServiceImpl implements IssueService {
    UserRepository repository;
    IssueRepository issueRepository;
//    private static Map<Long, Issue> issueRepo = new HashMap<>();
//    static {
//        Issue issue = new Issue();
//        issue.setId(1l);
//        issue.setName("Koko");
//        issueRepo.put(issue.getId(), issue);
//
//        Issue almond = new Issue();
//        almond.setId(2l);
//        almond.setName("Almond");
//        issueRepo.put(almond.getId(), almond);
//    }

    @Override
    public void createIssue(Issue issue) {

        issueRepository.save(issue);
    }
    @Override
    public void updateIssue(Long id, Issue issue) {
//        issueRepository.remove(id);
//        issue.setId(id);
//        issueRepository.put(id, issue);
    }
    @Override
    public void deleteIssue(Long id) {
//        issueRepository.remove(id);

    }
    @Override
    public Collection<Issue> getIssuesByUser(Long userId) {
        return issueRepository.findByUserId(userId);
    }
}