# Introduction

FlexRit, a vehicle journey registration application that allows the end user to easily and quickly enter and keep track of kilometers traveled by car. By using this application, the end user can manually enter all trips made during a work period. After entering the departure and arrival address, a calculation is automatically made of the total kilometers traveled. The purpose of this application is to collect the entered data and convert it into a clear report, so that this could be used for the end user's own administration.

### This project built using Java and the following tools:

- IntelliJ IDEA
- Spring Boot as server side framework
- Maven as build automation tool
- Hibernate as ORM / JPA implementation
- PostgreSQL as database implementation
- pgAdmin 4 as GUI client
- Spring Data JPA as the top layer over Hibernate
- Postman
- MacOS Monterey version 12.0.1


### Use-case diagram
The use-case diagram provides insight into which actors play a role and what their relationship is to the various parts of the system.
See Appendix A

### Installation
Software required:

- Java Development Kit (JDK) version 8 or newer.
- Intellij (or
- Git
- PostgreSQL Database
- Postman

# Step to set-up

### 1. Clone the application


- **Option A**

There are several ways to clone a Git repository to your local machine. You can use HTTPS or SSH, amongst other options. When we click the clipboard icon, the URL will be copied to our clipboard.
![](https://github.com/gmhislop/flex-rit/blob/6c6a4cc4cdb85011405f4b46149ffe9327a18d72/Images/import%20https%20repo.png)

![](https://github.com/gmhislop/flex-rit/blob/6c6a4cc4cdb85011405f4b46149ffe9327a18d72/Images/repo%20link%20.png)

- **Option B**
1. Download the zip.
2. Launch IntelliJ IDEA.
3. If the Welcome screen opens, click Open.
4. Otherwise, from the main menu, select File | Open.
5. In the dialog that opens, select the directory in which your sources, libraries, and other assets are located and click Open.

![](https://github.com/gmhislop/flex-rit/blob/6c6a4cc4cdb85011405f4b46149ffe9327a18d72/Images/import%20file%20github%20zip.png)

![](https://github.com/gmhislop/flex-rit/blob/6c6a4cc4cdb85011405f4b46149ffe9327a18d72/Images/Import%20file%20git%20hub.png)

>Now IntelliJ will show the project and let it complete loading and indexing

### 2. Configuring database

Open ```src/main/resources/application.properties ```

>Please update the application properties with your database specific properties
Spring.url, Username and Password with user details. Change PostgreSQL username and password as per your installation.
Replace {{INSERT_NAME_DB}} with the name of your DATABASE.


```
spring.datasource.url=jdbc:postgresql://localhost:5432/{{INSERT_NAME_DB}}
spring.datasource.username=postgres
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
jwt.token.validity=18000
jwt.signing.key=novi
jwt.authorities.key=roles
jwt.token.prefix=Bearer
jwt.header.string=Authorization
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL81Dialect
```

Go to ```src/main/java/com/novi/flexrit/FlexritApplication.java```

Right click on main method and select **Run Application**
Server will be started

Go to pgAdmin. Open the database. You will see all the tables created.
Copy the following 2 insert statements and paste them into the Query editor at ```pgAdmin```.


```
(role_id, description, name)
VALUES(0, 'ADMIN', 'ADMIN');

INSERT INTO role
(role_id , description, name)
VALUES(1, 'USER', 'USER'); 
```
>Please run these insert statements to add user and admin role
INSERT INTO role. Run those two sql. Now role table will have 2 rows with USER and ADMIN role.

### 3. Configurating Postman


Launch Postman.
1. To open the Postman application, click on its icon on the taskbar.
2. Click on the file tab or the button next to My Workspace and then click import.
3. Choose the method you want to import an item.
4. Choose the correct item to import and press open. Postman will automatically import the item.
   ```/flexrit/Flexrit.postman_collection.json```


![](https://github.com/gmhislop/flex-rit/blob/6c6a4cc4cdb85011405f4b46149ffe9327a18d72/Images/Postman%20import.png)

By executing the following requests you can make sure everything works properly:

**User Registration**
This will register a user. Then run login it will generate token copy that and run the addUser request from postman. It will add a user into database.

**User login**
Run a login request by providing the username and password which you used while registration. It will generate a token. Copy this token as this will be used in further steps.

**Add Vehicle**
Click on add Vehicle Request. Paste the copied token to the header authorization value.
Send the request. This will add a vehicle to the database.

![](https://github.com/gmhislop/flex-rit/blob/69d1d39430b87a0cec6820ebe2ae388777a68638/Images/Postman%20request.png)