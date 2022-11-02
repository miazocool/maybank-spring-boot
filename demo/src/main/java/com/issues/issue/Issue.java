package com.issues.issue;

import javax.persistence.*;

@Entity
@Table(name = "issue")
public class Issue {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String body;
    private String url;
    private String repository_url;
    public Issue() {}

    public Issue(String title, String body, String url, String repository_url) {
        this.title = title;
        this.body = body;
        this.url = url;
        this.repository_url = repository_url;
    }
    @Override
    public String toString() {
        return String.format(
                "Issue[id=%d, body='%s', url='%s', repository_url='%s']",
                id, body, url, repository_url);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRepository_url() {
        return repository_url;
    }

    public void setRepository_url(String repository_url) {
        this.repository_url = repository_url;
    }

    public void setId(Long id) {
        this.id = id;
    }
};
