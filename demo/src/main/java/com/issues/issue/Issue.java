package com.issues.issue;

import javax.persistence.*;

@Entity
@Table(name = "dbo.issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long userId;
    private String description;
    private String githubIssueId;
    protected Issue() {}

    public Issue(String name, String description, String githubIssueId) {
        this.name = name;
        this.description = description;
        this.githubIssueId = githubIssueId;
    }
    @Override
    public String toString() {
        return String.format(
                "Issue[id=%d, name='%s', description='%s', githubIssueId='%s']",
                id, name, description, githubIssueId);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGithubIssueId() {
        return githubIssueId;
    }

    public void setGithubIssueId(String githubIssueId) {
        this.githubIssueId = githubIssueId;
    }
};