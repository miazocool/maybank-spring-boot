package com.issues.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUser() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "User with id " + id + " has been removed";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @RequestMapping(value = "/users/{offset}/{pageSize}", method = RequestMethod.GET)
    private Page<User> getUsersWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<User> productsWithPagination = userService.findUsersWithPagination(offset, pageSize);
        return productsWithPagination;
    }
}