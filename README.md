# FinTech-API
Banking API that allows users to lend other users money.

Built with:
Spring Boot
Maven
JPA Hibernate
H2

Running the server locally
Build the Spring Boot app so that it can run. Open the project file in your IDE of choice. 
To run it from the terminal, open your IDE’s terminal and use the following command:
1.	Install the maven plugin:

Mvn install.

 Then you need to run the app with the following command:
Mvn spring-boot:run 

You can also run the app using the run configuration of the IDE you are using. 

Database:
This API uses an H2 database but you can replace it with any database you choose.
To access the H2 database first run the application then in your browser enter the following URL:
http://localhost:8081/h2-console.

You can change the port number for your local host depending on your setup. 
In the H2 console, you can manage your database and load it with more user info, if you wish to. 

Dummy Data:
The app has dummy user info that it creates for you to test the API. 
You can also create dummy users inside the H2 database or whichever database software you have chosen.  

API Documentation:
There are several endpoints you can test out with the app running. 
It uses JSON objects to make the requests.
It also uses HTTP Authorization request headers, to make the request based on user credentials. 
The user credentials here are the user’s names. 
Use them in any API client you choose. 

http://localhost:8080/users (GET)
This is used to find all the users in the database.

http://localhost:8080/topup (POST)
This is used to deposit money into a user’s account.

http://localhost:8080/withdraw (POST)
This is used to withdraw money from a user’s account.

http://localhost:8080/loan/request (POST)
This is used to request a loan from another user. 

http://localhost:8080/loan/accept/{loanApplicationId} (POST)
This is used to accept to accept another user’s loan request.

http://localhost:8080/loans (GET)
This is used to return all the loans in the database. 

http://localhost:8080/loan/repay (POST)
This is used to repay a loan request that a user has made.

http://localhost:8080/loan/{status}/lent (GET)
This is used to find all the lent loans.

http://localhost:8080/{status}/borrowed (GET)
This is used to find all the borrowed loans.
