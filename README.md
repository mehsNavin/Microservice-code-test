**About the project**

shopping-app-microservice is a sample Microservice which provides the below functionalities.

    It can  create a transaction for the customer.
    It lists the total cost of transactions per customer.
    It lists the total cost of transactions per product.
    It lists the number of transactions sold to customer from Australia.

**How to run the project**

**Prerequisites**
Java 8
Maven
GitBash or CMD

**Build and Run**

Apply below command to Build and Run the Application.

**Build:**
> mvn clean install
The above command will build the application and create a jar file with name 'shopping-app-microservice-<version>-SNAPSHOT.jar'

**Run:**
> mvn spring-boot:run
or
> java -jar target/shopping-app-microservice-0.0.1-SNAPSHOT.jar
The above two command will run the application from the command line

**Functionalities**

**Initial Customer And Product Details**
Assume that the application is already in progress and it holds a list of customers and products in DB.
To achieve this, the application will load a list of customers with their emailID, location and also loads list of products with their status from local /src/java/resources/data.sql to the given repository.

**Create a transaction for a customer**

curl --location --request POST 'http://localhost:8080/v1/belong/phoneNumbers/0469001001' \
--data-raw '{
    "transactionTime": "2022-05-25 14:56",
    "customerID": "10001",
    "quantity": "3",
    "productCode": "PRODUCT_001"
}'

**List the total cost of transactions per customer**

curl --location --request GET 'http://localhost:8080/shopping/getcustomer/10001'

**List the total cost of transactions per product**

curl --location --request GET 'http://localhost:8080/shopping/getproduct/PRODUCT_001'

**List the number of transactions sold to customer from a location**

curl --location --request GET 'http://localhost:8080/shopping/getTransactionCount/Australia'

