package com.issues.issue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class IssueController {
    @Autowired
    IssueService issueService;

//    @RequestMapping(value = "/issues")
//    public ResponseEntity<Object> getIssue() {
//        return new ResponseEntity<>(issueService.getIssues(), HttpStatus.OK);
//    }

    @RequestMapping(value = "/issues/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateIssue(@PathVariable("id") Long id, @RequestBody Issue user) {
        issueService.updateIssue(id, user);
        return new ResponseEntity<>("Issue is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/issues/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        issueService.deleteIssue(id);
        return new ResponseEntity<>("Issue is deleted successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/issues", method = RequestMethod.POST)
    public ResponseEntity<Object> createIssue(@RequestBody Issue user) {
        issueService.createIssue(user);
        return new ResponseEntity<>("Issue is created successfully", HttpStatus.CREATED);
    }
//    @RequestMapping(value = "/issues/{userId}")
//    public ResponseEntity<Object> getIssueByUserId(@PathVariable Long userId) {
//        return new ResponseEntity<>(issueService.getIssuesByUser(userId), HttpStatus.OK);
//    }

}
