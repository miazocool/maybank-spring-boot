package com.issues.models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String githubId;

    // standard constructors / setters / getters / toString
    public UserModel(String name, String githubId) {
        this.name = name;
        this.githubId = githubId;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, name='%s', githubId='%s']",
                id, name, githubId);
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

    public String getGithubId() {
        return githubId;
    }

    public void setGithubId(String githubId) {
        this.githubId = githubId;
    }
};