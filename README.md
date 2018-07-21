# Feed the hungry Java Developers Lunch 

#### Scenario 

You are a hungry Java Developer. You want lunch! 

You have the contents of the kitchen at your disposal, as well as your recipies. 

How else does a Java developer find his lunch. They write an api to sift out the usable ingredients and determine the recipes. 

Only ingredients within there usedby date can be used. All ingredients close to the best by date sort the recipies to the bottom of the list. 

Eat up.    

#### System Requirements 

Java 10 is required 

#### Building 

To build run  
`mvn clean install` in the HungryDeveloper directory

For example: 
`~/project/HungryDeveloper> mvn clean install`

#### Running 
To run the application
`mvn spring-boot:run`

In a browser hit: 
`http://localhost:8080`

and you will be presented with swagger so you can try out the 
services.

Try lunch: 
`http://localhost:8080/lunch`
