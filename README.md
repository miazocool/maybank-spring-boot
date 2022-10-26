# maybank-spring-boot
A test from maybank, the system is a view for Github Issues list.

## Program flow
https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=github-issue-tracker#Uhttps%3A%2F%2Fdrive.google.com%2Fuc%3Fid%3D1nKWw9-CcLcq73BanWV8GfszAiFp55jBl%26export%3Ddownload

## Class diagram
private User()
- id
- name
- githubID

private Issue()
- id
- name 
- description (nullable)
- githubIssueID (nullable)

## Functionality:
- Signup using github login API 
- Fetch data from Github (GET) -> Insert all into DB
- Create local issue? 
Insert into local DB only, won't do POST to githubAPI
- Listing of issue (either from fetch or from local created)
Will have a tag on each issue that shows
  1. local issue
  2. github issue
- View all issues 
Displaying from local DB, if issues from github are fetched
Else -> Throw error, empty issue list, please
  1. Create one issue or fetch from github
- Create an issue (POST)
- Update an issue (PUT)
- Delete an issue (DELETE)
