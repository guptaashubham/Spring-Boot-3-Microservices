# Microservices Project

This project is a microservices-based application that demonstrates a simple e-commerce system. It consists of several services that work together to handle product management, inventory tracking, and order processing.

## Services

1. **API Gateway**: Acts as a single entry point for all client requests.
2. **Product Service**: Manages product information.
3. **Inventory Service**: Tracks product inventory.
4. **Order Service**: Handles order creation and management.

## Technologies Used

- Java 21
- Spring Boot 3.x
- Spring Cloud
- MySQL
- Docker
- WireMock (for testing)
- Testcontainers (for integration testing)

## Prerequisites

- Java Development Kit (JDK) 21 or later
- Docker and Docker Compose
- Maven

## Setup

1. Clone the repository:
   ```
   git clone https://github.com/guptaashubham/Spring-Boot-3-Microservices.git
   cd microservices-project
   ```

2. Build the project:
   ```
   mvn clean package
   ```

3. Start the services using Docker Compose:
   ```
   docker-compose up -d
   ```

## Running the Application

Once all services are up and running, you can access the API through the API Gateway at `http://localhost:8084`.

### Example Requests

1. Create a product:
   ```
   POST http://localhost:8084/api/product
   {
     "name": "Samsung S20",
     "description": "Samsung Galaxy S20 smartphone",
     "price": 999.99
   }
   ```

2. Check inventory:
   ```
   GET http://localhost:8084/api/inventory?skuCode=Samsung S20&quantity=100
   ```

3. Place an order:
   ```
   POST http://localhost:8084/api/order/create
   {
     "skuCode": "Samsung S20",
     "price": 999.99,
     "quantity": 100
   }
   ```

## Testing

The project includes unit tests and integration tests. To run the tests:

```
mvn test
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
