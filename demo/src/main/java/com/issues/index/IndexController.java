package com.issues.index;

import com.issues.issue.Issue;
import com.issues.issue.IssueService;
import com.issues.user.User;
import com.issues.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
    UserService userService;
    IssueService issueService;

    //In index there is user form to fetch github api to
    // list down the issues based on the github username
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("github", new User());
        return "index";
    }

    //     @GetMapping("https://api.github.com/users/{username}")
////     @ResponseBody
//     public String index(@PathVariable String username) {
////         model.addAttribute("issues", issueService.getIssues());
//         issueService.getIssues();
//         return "index";
//     }
    @PostMapping("/github-login")
    public String github(@ModelAttribute User user, Model model) {
        model.addAttribute("github", user);
        return "result";
    }
}