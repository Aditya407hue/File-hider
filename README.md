Java mini project over view

Used sql for the database part 

Understand maven 

Pom.xml - project object model - heart of maven project - used to add dependencies (other peoples code ) 

File hidder 

I have tried to distribute the work as much as possible and tried to build reusable components. Also i have used do while so that after doing one operation the program doesnt close user can press the req button for exiting the program 

Made on MVC(model view controller )  pattern - i havent created the controller part since it is a small project  but the services part kind of act like a controller here .

Model - User model 
Data model - What ever info we need to store the file in data base are mentioned or modelled in the data model - id,filename , path , email 

User model similarly contains the info about the what info we need from user - name , email 

View - 
Welcome view - Have the welcome screen 
User view - In file hiding using file reader we will first convert the file into character stream and delete the file from path , and it will be hidden and when the user want to unhide the file we will simply convert the character data stored in database into a new file 

Services - Basically contains the business logics what we want to do with the app are mainly mentioned in the services part 
OTP service - to build an unique otp 
sendOtp service - to send otp - it will take the details like sender , receiver 
User service - to check if the user exists or not 

DAO - data access objects - main work of bringing the data from database
Data DAO will have data about the file in the database like the files in this case
User DAO will help to access the user data 

Main class - have a main method and we are calling a welcome screen in main class
