package com.issues.index;

import com.issues.issue.IssueService;
import com.issues.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    UserService userService;
    IssueService issueService;
    @GetMapping("/index")
    public String index(Model model) {
//        model.addAttribute("issues", issueService.getIssues());
        return "index";
    }
}