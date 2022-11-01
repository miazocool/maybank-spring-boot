# maybank-spring-boot
A test from maybank, the system is a view for Github Issues list.

# Explore API
GET http://localhost:8080/users
- Will get all users 

POST http://localhost:8080/users
- Will create a new user
```
{
  "name": "HelloTesting",
  "githubId": "mygithubid"
}
```

PUT http://localhost:8080/users/<id>
- Will update user based on id provided
```
{
  "name": "Mygithubidhasbeenuypdated",
  "githubId": "testing123"
}
```
DELETE http://localhost:8080/users/<id>
- Will delete user based on id provided

GET http://localhost:8080/users/<offset>/<pageSize>
 - Will get all users by pagination from offset and pageSize

# requirements 
1. Create a Java SpringBoot Application.
2. Project Structure is required for ease of maintainability and readability.
3. Explore api for Client (Example: to be test via Postman. Please provide the Postman Collection.)
4. Each api required to log REQUEST & RESPONSE info into logs file.
5. Your project able connect to database, preferred with MSSQL database (Using Local Machine DB, DB name: TESTDB).
- @transactional is required implement in the project. (For http Methos: INSERT, UPDATE, GET method)
6. Explore 1 GET method api with Pagination (Each Page 10 records)
7. Explore an api which will nested calling another api from 3rd party.
Example: Postman/Client > Your API Endpoint > calling another api

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

# To remember

to see gradle version : 
'''
./gradlew -v
'''
run gradle :
'''
./gradlew bootRun
'''
