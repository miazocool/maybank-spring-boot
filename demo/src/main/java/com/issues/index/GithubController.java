package com.issues.index;

import com.issues.issue.Issue;
import com.issues.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/github")
public class GithubController {
    String github_uri = "https://api.github.com/";

    @GetMapping("/login{github-username}")
    public List<User> index(@PathVariable String github_username) {
        String BASE_ENDPOINT = github_uri + "users/" + github_username;
        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(uri, String.class);
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(BASE_ENDPOINT, User[].class);
        User[] userArray = responseEntity.getBody();
        return Arrays.stream(userArray)
                .map(x -> {
                    System.out.println(x);
                    return x;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/fetch-isssue/{github_username}/{repo_name}")
    public List<Issue> fetchIssue(String github_username, String repo_name, Model model) {
        String BASE_ENDPOINT = github_uri + "repos/" + github_username + "/" + repo_name + "/issues";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Issue[]> responseEntity = restTemplate.getForEntity(BASE_ENDPOINT, Issue[].class);
        Issue[] issueArray = responseEntity.getBody();
        return Arrays.stream(issueArray)
                .map(x -> {
                    System.out.println(x);
                    return x;
                })
                .collect(Collectors.toList());
    }
}
