package com.issues.issue;

import java.util.Collection;

public interface IssueService {
    public abstract void createIssue(Issue product);
    public abstract void updateIssue(Long id, Issue product);
    public abstract void deleteIssue(Long id);
    public abstract Collection<Issue> getIssues();
}
