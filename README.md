# maybank-spring-boot
A test from maybank

The system is a view for Github Issues list.

private User()
- id
- name
- githubID

private Issue()
- id
- name 
- description (nullable)
- githubIssueID (nullable)

Functionality:
-Signup using github login API 
--Fetch data from Github? -> Insert all into DB
--Create local issue? -> 3
-Listing of issue (either from fetch or from local created)
-View all issues (GET from githubAPI)
-Create an issue (POST)
-Update an issue (PUT)
-Delete an issue (DELETE)
