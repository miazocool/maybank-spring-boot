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
1.-Signup using github login API 
  --Fetch data from Github? -> Insert all into DB
  --Create local issue? -> 3
  -Listing of issue (either from fetch or from local created)
2. View all issues (GET from githubAPI)
3. Create an issue (POST)
4. Update an issue (PUT)
5. Delete an issue (DELETE)
