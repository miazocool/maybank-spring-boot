package com.issues.github;

import com.issues.issue.Issue;
import com.issues.issue.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/github")
public class GithubController {
    String GITHUB_URI = "https://api.github.com/";
    @Autowired
    IssueService issueService;
    @GetMapping("/login/{githubUsername}")
    public GithubModel loginGithub(@PathVariable("githubUsername")String githubUsername) {
        //Endpoint to retrieve github user info
        String BASE_ENDPOINT = GITHUB_URI + "users/" + githubUsername;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<GithubModel> responseEntity = restTemplate.getForEntity(BASE_ENDPOINT, GithubModel.class);
        GithubModel githubModel1 = responseEntity.getBody();
//        githubModel.setFollowers_url(responseEntity.getBody().getFollowers_url());
//        githubModel.setLogin(responseEntity.getBody().getLogin());
//        githubModel.setRepos_url(responseEntity.getBody().getRepos_url());
//        githubModel.setUrl(responseEntity.getBody().getUrl());
//        model.addAttribute("github_user", github_user);
        return githubModel1;
    }

    @GetMapping("/fetch-issue/{githubUsername}/{repoName}")
    public List<Issue> fetchIssue(@PathVariable String githubUsername, @PathVariable String repoName) {
        String BASE_ENDPOINT = GITHUB_URI + "repos/" + githubUsername + "/" + repoName + "/issues";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Issue[]> responseEntity = restTemplate.getForEntity(BASE_ENDPOINT, Issue[].class);
        Issue[] issueArray = responseEntity.getBody();
        return Arrays.stream(issueArray)
                .map(issue -> issueService.createIssue(issue))
                .collect(Collectors.toList());
    }
}
