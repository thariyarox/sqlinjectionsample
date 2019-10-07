SQL Injection Demo Web Application

Follow the steps below for running the sample.

1. Set up mysql database with name 'webapp'. 
For creating the required tables, refer the dbscrip file provided in the project files.

2. Here, the mysql credentials are used as root/mypassword. 
If your mysql user credentials are different, modify the source code and build the project with Maven.

3. A pre-built webapp is available here, dbsample.war.

4. Deploy the war file in Tomcat Server. The web application can be accessed on http://localhost:8080/dbsample if tomcat runs on 8080 port.

5. In the dbscript, sample user credentials are given. Use any of them to login to the application.

6. For trying out sql injection, use the following payload in the text boxes.

a' or '1'='1