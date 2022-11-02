package com.issues.user;

import com.issues.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUser() {
        List<User> users = List.of();
        log.info("GET REQUEST : Retrieving all users");
        try {
            users = userService.getUsers();
        }catch (Exception e){
            log.info("GET REQUEST ERR : Something went wrong" + e.toString());
            return List.of();
        }
        log.info("RESPONSE : Users retrieved" + Arrays.toString(users.toArray()));
        return users;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        log.info("PUT REQUEST : Updating a user with id : " +id);
        try {
            user = userService.updateUser(id, user);
        }catch (Exception e){
            log.info("PUT REQUEST ERR : Something went wrong " + e.toString());
            return null;
        }
        log.info("RESPONSE : User updated : " + user.toString());
        return user;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
        log.info("DELETE REQUEST : Deleting a user with id : " +id);
        try {
            userService.deleteUser(id);
        }catch (Exception e){
            log.info("DELETE REQUEST ERR : Something went wrong" + e.toString());
            return "Something Wrong";
        }
        log.info("RESPONSE : User deleted");
        return "User with id " + id + " has been removed";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        log.info("POST REQUEST : Creating a new user");
        try {
            user = userService.createUser(user);
        }catch (Exception e){
            log.info("POST REQUEST ERR : Something went wrong" + e.toString());
            return null;
        }
        log.info("RESPONSE : User has been created : " + user.toString());
        return user;
    }
    @RequestMapping(value = "/users/{offset}/{pageSize}", method = RequestMethod.GET)
    private Page<User> getUsersWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        log.info("GET REQUEST : Pagination with " + offset + " offset, and " + pageSize + " pageSize");
        Page<User> productsWithPagination = userService.findUsersWithPagination(offset, pageSize);
        log.info("RESPONSE : Pagination success");
        return productsWithPagination;
    }
}