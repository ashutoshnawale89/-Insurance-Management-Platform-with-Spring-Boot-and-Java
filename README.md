# Insurance Management Platform with Spring Boot and Java.

#Brief explaination on the project

1) First create new project using spring initializer with add necessary dependencies.
2) In the project first create ENTITY/MODEL Class assigne the variable and every class decleared one primary key as ID.Then Create DTO(data transfer object) it is basically use for user can not directly access the model.Then Create Repository for all to connect with database.
3) In the next step we create service class for all the categories and then create Controll for all the domains.
4) The flow of the project is client make request using domain URL and then request go to the MAIN class. Main class is annoted by SpringBootApplication it work as scan the subpackage and configure the bean and these bean are handle SpringContainer and then request go to the Controller.Controller Transfer the request in service package for particular request or logical part is required and the return it.

5) In the project we use primary key for connecting the one model/entity to another model/entity.
6) First step for client is client make registration using "POSTMethod /api/clients" url.
7) Many policies in database to store and client can be choice any.
7) Then client seen and purchase the some policies according to client condition using particular url.
8) If the client make the claims that policies so it will do.



# RESTful APIs for the following actions or Domain of all the RESTful Api's: 
#a. Clients: 
      i. GET-Request    /api/clients: Fetch all clients. 
      ii. GET-Request   /api/clients/{id}: Fetch a specific client by ID. 
      iii. POST-Request  /api/clients: Create a new client. 
      iv. PUT-Request    /api/clients/{id}: Update a client's information. 
       v. DELETE-Request  /api/clients/{id}: Delete a client. 

#b. Insurance Policies: 
i. GET-Request   /api/policies: Fetch all insurance policies. 
ii. GET-Request   /api/policies/{id}: Fetch a specific insurance policy by ID. 
iii. POST-Request  /api/policies: Create a new insurance policy. 
iv. PUT-Request    /api/policies/{id}: Update an insurance policy. 
v. DELETE-Request   /api/policies/{id}: Delete an insurance policy. 

#b. Buying Policies: 
i. GET-Request   /api/buypolicies: Fetch all insurance policies. 
ii. GET-Request   /api/buypolicies/{id}: Fetch a specific insurance policy by ID. 
iii. POST-Request  /api/buypolicies: Create a new insurance policy. 
iv. PUT-Request    /api/buypolicies/{id}: Update an insurance policy. 
v. DELETE-Request   /api/buypolicies/{id}: Delete an insurance policy. 

#c. Claims: 
i. GET-Request   /api/claims: Fetch all claims. 
ii. GET-Request   /api/claims/{id}: Fetch a specific claim by ID. 
iii. POST-Request  /api/claims: Create a new claim. 
iv. PUT-Request    /api/claims/{id}: Update a claim's information. 
v. DELETE-Request   /api/claims/{id}: Delete a claim. 