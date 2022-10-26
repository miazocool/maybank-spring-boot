package com.issues.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "issue")
public class IssueModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;
    private String githubIssueId;

    public IssueModel(String name, String description, String githubIssueId) {
        this.name = name;
        this.description = description;
        this.githubIssueId = githubIssueId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
