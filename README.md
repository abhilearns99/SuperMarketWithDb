# SuperMarketWithDb

Tech used
-------------
Version Control System: Git
Source Code Management: GitHub
Database Management System: Postgres (local)
Back-End Programming Language: Java
API Development Platform: SpringBoot
Build Tool: Maven
Unit & Integration testing: JUnit and Mockito

MVP (Minimum Viable Product) Checklist
---------------------------------------
Codebase:
Spring Boot API with full CRUD functionality.
Sensible package structure (back-end).
Adherence to best practices.

Testing:
Unit and integration testing for the project back-end.
Reasonable test coverage of the src/main/java folder
Continuous Integration (CI):
GitHub repository utilising the feature-branch model
The main branch must compile
A build of the application is present in the root folder of your git repo
 .jar which can be deployed from the command-line (java -jar target/superMarket.jar)

Installation
--------------
Clone the Application from github repo:
git clone https://github.com/abhilearns99/SuperMarketWithDb.git

Installing Postgres
---------------------
Install postgres in local and use the same username and password as mentioned in the src/main/resources/application.properties .
Create a database named superMarketdb by running the below DDL query:
CREATE DATABASE `superMarketdb`


Executing the application
-------------------------
cd supermarket
java -jar target/superMarket.jar

In postgres, a table products should now be created

Go to postgres SQL editor and run the below DML queries to make the initial product entries:

INSERT INTO public.products (product_id, name, quantity, section, unit_price)
VALUES ('c97e58f9-fbb5-4bf0-a48d-10bbd489414a', 'Lettuce', 16, 'PRODUCE', 3.46);
INSERT INTO public.products (product_id, name, quantity, section, unit_price)
VALUES ('42903434-6a6d-459a-9b06-1b71c7a39710', 'Popsicles', 4,'FROZEN', 2.99);
INSERT INTO public.products (product_id, name, quantity, section, unit_price)
VALUES ('564d3565-04a1-4caa-81ce-957506ecfcfa', 'Green Pepper', 22, 'PRODUCE', 0.79);
INSERT INTO public.products (product_id, name, quantity, section, unit_price)
VALUES ('4d1e5941-2efc-480f-970d-c6216e33c0e4', 'Sliced Roast Beef', 7,'DELI', 7.59);
INSERT INTO public.products (product_id, name, quantity, section, unit_price)
VALUES ('9b14ec39-93de-4cb7-b5ab-34f4b59c549c', 'Plain Bagel', 13, 'BAKERY', 1.27);
INSERT INTO public.products (product_id, name, quantity, section, unit_price)
VALUES ('a15dcd66-fe6d-4bf9-b957-0735c6f07305', 'Orange Juice', 6, 'BEVERAGE', 2.38);
INSERT INTO public.products (product_id, name, quantity, section, unit_price)
VALUES ('587acd25-403f-4188-b536-dff1bfe85b7c', 'Banana', 1, 'PRODUCE', 10.00);
INSERT INTO public.products (product_id, name, quantity, section, unit_price)
VALUES ('df4ba7e6-4908-426c-b101-84ffde50dfed', 'Tortilla Chips', 0, 'PANTRY', 4.49);
INSERT INTO public.products (product_id, name, quantity, section, unit_price)
VALUES ('45abb9b0-972c-4f3a-9e1d-9ecc6ac8609b', 'Blueberry Muffin', 16, 'BAKERY', 1.73);


API access and requests
------------------------
The API can be accessed using Postman or Insomnia.

I will demonstrate API requests using Postman below.

API functionality :
The following  functionality is specified 

a GET route to retrieve a product by ID: http://localhost:8080/api/products/{product_id}
a GET route to retrieve for all products: http://localhost:8080/api/allproducts
a GET route to retrieve all products in a particular section: http://localhost:8080/api/products/productsBySection?section={sectionname}
a GET route to retrieve all in-stock products: http://localhost:8080/api/products/inStock
a POST route to add a new product: http://localhost:8080/api/addProduct
        Body example:
                {
                "name": "Beans",
                "quantity": 2,
                "section": "Pantry",
                "unit_Price": 3.02
                }

Unit Testing
---------------
Run all the tests in com/usaToday/supermarket/service/ProductServiceTest.java
There is a unit test added for each method call.

