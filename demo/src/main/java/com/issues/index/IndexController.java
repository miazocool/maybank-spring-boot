package com.issues.index;

import com.issues.issue.IssueService;
import com.issues.user.User;
import com.issues.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
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
//    @PostMapping("/create")
//    public String doCreateUser(@Valid @ModelAttribute("formData") CreateUserFormData formData,
//                               BindingResult bindingResult,
//                               Model model) {
//        if (bindingResult.hasErrors()) {
//            return "users/create";
//        }
//
//        userService.createUser(formData.toParameters());
//
//        return "redirect:/users";
//    }
}