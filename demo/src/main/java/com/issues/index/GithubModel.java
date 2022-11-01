package com.issues.index;

import javax.persistence.*;

@Entity
@Table(name = "dbo.github")
public class GithubModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String url;
    private String repos_url;
    private String followers_url;
    public GithubModel(){}
    public GithubModel(Long id, String login, String url, String repos_url, String followers_url) {
        this.id = id;
        this.login = login;
        this.url = url;
        this.repos_url = repos_url;
        this.followers_url = followers_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }
}
