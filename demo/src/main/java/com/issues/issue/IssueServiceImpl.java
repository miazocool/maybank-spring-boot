package com.issues.issue;

import com.issues.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueServiceImpl implements IssueService {
    @Autowired
    UserRepository repository;
    @Autowired
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
    public Issue createIssue(Issue issue) {
        issueRepository.save(issue);
        return issue;
    }
    @Override
    public Issue updateIssue(Long id, Issue issue) {
//        Issue updatingIssue = issueRepository.findById(id).orElse(null);
//        updatingIssue.setName(user.getName());
//        updatingIssue.setGithubId(user.getGithubId());
//        repository.save(updatingUser);
        return null;
    }
    @Override
    public void deleteIssue(Long id) {
//        issueRepository.remove(id);

    }
//    @Override
//    public Collection<Issue> getIssuesByUser(Long userId) {
//        return issueRepository.findByUserId(userId);
//    }
}