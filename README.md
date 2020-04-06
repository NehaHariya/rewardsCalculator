# rewardsCalculator
Calculates the rewards based on amount of each transaction.

This repository is a Spring boot application and has a Restful service /customer/rewards/ which returns calculated rewards for each month and total rewards for each customer.

There is sample data in RewardsService for 3 customers for 3 months.

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

How to Run
This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. 

Clone this repository
Make sure you are using JDK 1.8 and Maven 3.x
You can build the project by running mvn clean package
Once successfully built, you can run the application by running mvn spring-boot:run
Once successfully started, you can call the service from any browser using url:
        http://localhost:8080/customer/rewards/
