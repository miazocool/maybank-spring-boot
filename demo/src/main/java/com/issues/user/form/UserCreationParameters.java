package com.issues.user.form;

import org.springframework.util.Assert;

public class UserCreationParameters {
    private final String name;
    private final String githubId;

    public UserCreationParameters(String name,
                                  String githubId) {
        Assert.notNull(name, "name should not be null");
        Assert.notNull(githubId, "githubId should not be null");
        this.name = name;
        this.githubId = githubId;
    }

    public String getName() {
        return name;
    }

    public String getGithubId() {
        return githubId;
    }
}
