package com.issues.issue;

public interface IssueService {
    public abstract Issue createIssue(Issue issue);
    public abstract Issue updateIssue(Long id, Issue issue);
    public abstract void deleteIssue(Long id);
//    public abstract Collection<Issue> getIssuesByUser(Long id);
}
