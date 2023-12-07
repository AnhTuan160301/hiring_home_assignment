# hiring_home_assignment based on Spring boot.
Implementing the spring boot project using the Maven to manage dependencies.
Using the Spring Data Jpa to store the data in MySQL persistent. 
Using the Sring Sercurity to implement the simple authentication and authorization for the API endpoints. 
Description:
- Data Model: Task(id, title, description, isCompleted)
- Task's API:
  + User:  Get All Tasks
           /Get Task By Id
  + Admin:  Create the tasks
           / Update the tasks
           / Delete the tasks
           / Get All Tasks
           / Get Task By Id
- The "/welcome" is the available for all users. And, the users have to login to access to "/tasks". For as simple as possible, we create the user and admin account in the memory of application and these will be deleted when stopping app.
  + User:    username: user  and password: 12345
  + admin:   username: admin and password: 12345
