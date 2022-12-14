# maybank-spring-boot
A test from maybank

## NOTES
- log file is located at \maybank-spring-boot\demo
- rdbms used is mssql, the name of db is testdb

# Explore API
GET http://localhost:8080/users
- Will get all users 

POST http://localhost:8080/users
- Will create a new user with the following body
```
{
  "name": "UserTesting123",
  "githubId": "githubIdTesting123"
}
```

PUT http://localhost:8080/users/id
- Will update user based on id and body provided
- eg : http://localhost:8080/users/1
- body
```
{
  "name": "UserUpdated123",
  "githubId": "githubIdUpdated"
}
```
DELETE http://localhost:8080/users/id
- Will delete user based on id provided
- eg : http://localhost:8080/users/1

GET http://localhost:8080/users/offset/pageSize
- Will get all users by pagination from offset and pageSize
- eg http://localhost:8080/users/0/5
- will get the first 5 elements
- eg http://localhost:8080/users/1/5
- will get 6th until 10th element

GET http://localhost:8080/login/githubUsername
- Will get the current user info
- The github profile must be public
- eg http://localhost:8080/login/miazocool

GET http://localhost:8080/github/fetch-issue/githubUsername/repositoryName
- Will get all the issues belonging to github username and github repo
- The repo and user must be public available
- eg: http://localhost:8080/github/fetch-issue/miazocool/maybank-spring-boot
- after fetching from github, will later insert into issue table.


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

## Functionality:
- Fetch github login.
- Fetch issue from github user, repo.
- Insert into issue table for all issues fetched.
- ATM module
  - Simulating cash withdrawal where it will check if the current amount in transaction history is bigger than the requested withdrawal amount
  - If the check is true, will return the balance, and insert a new row in transaction history table with the latest amount after withdrawal
  - By implementing @Transactional, we prevent the insert of row in transaction history table if there is an UnsufficientAmount exception
