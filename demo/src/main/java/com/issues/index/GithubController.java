package com.issues.index;

import com.issues.issue.Issue;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/github")
public class GithubController {
    String GITHUB_URI = "https://api.github.com/";

    @GetMapping("/login")
    public String index(@Valid @ModelAttribute("github_username") String github_username, Model model) {
        //Endpoint to retrieve github user info
        String BASE_ENDPOINT = GITHUB_URI + "users/" + github_username;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<GithubModel> responseEntity = restTemplate.getForEntity(BASE_ENDPOINT, GithubModel.class);
        GithubModel github_user = responseEntity.getBody();
        model.addAttribute("github_user", github_user);
        return "index";
    }

    @GetMapping("/fetch-isssue/{github_username}/{repo_name}")
    public List<Issue> fetchIssue(String github_username, String repo_name, Model model) {
        String BASE_ENDPOINT = GITHUB_URI + "repos/" + github_username + "/" + repo_name + "/issues";
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
