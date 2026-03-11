# AI Collaboration Challenge - Bulk Operations Feature

## Feature Request
Add a product update feature that allows users to perform basic update actions (price updates, category changes, deletion) with appropriate confirmation responses and error handling.

## 1. AI Tool Selection

**Which AI tool would you choose and why?**

For this task, I would use GitHub Copilot, specifically the Copilot Chat feature available in IDEs like IntelliJ IDEA, Eclipse or VS Code.

GitHub Copilot is useful because it can analyze the existing codebase context and generate suggestions that align with the current Spring Boot architecture (entity → repository → service). This helps ensure that any generated implementation follows the same structure and coding patterns already used in the project.

## 2. Comprehensive Prompt

**Write your complete prompt including context about the codebase architecture and any constraints:**

Act as an expert Java/Spring Boot developer. You are assisting with implementing a bulk operations feature in an existing Java Spring Boot application. Please analyze the repository and generate an implementation that fits naturally into the current structure and coding style.

Repository context:
	Project root: a Spring Boot app named productInventoryTracker.

Relevant files and responsibilities:
	* src/main/java/com/access/productInventoryTracker/model/Product.java - JPA entity with fields: id, name, price, category, available.
	* src/main/java/com/access/productInventoryTracker/dto/ProductDTO.java - simple DTO for products.
	* src/main/java/com/access/productInventoryTracker/service/ProductService.java - existing service; add bulk methods here.
	* src/main/java/com/access/productInventoryTracker/repository/ProductRepository.java - JpaRepository for Product.
	* There is an application.properties and tests under src/test/java.
	* src/test/java/com/access/productInventoryTracker/service/ProductServiceTest.java - unit tests for the service using Mockito. 
	* src/test/java/com/access/productInventoryTracker/ProductInventoryTrackerApplicationTests.java - basic Spring Boot context test.

Your task is to add support for bulk product operations, allowing the system to process multiple product actions in a single request. The implementation should support common batch operations such as:
	* creating multiple products
	* updating multiple products
	* deleting multiple products

Follow these guidelines while generating the solution:
	* Keep the implementation consistent with the current Spring Boot layered structure.
	* Business logic should remain inside the service layer, specifically in ProductService.
	* Reuse the existing ProductDTO where appropriate.
	* Introduce additional request/response DTOs if needed for bulk operations.
	* Prefer efficient repository operations such as saveAll() or deleteAllById() instead of looping individual database calls.
	* Ensure the solution handles validation (for example missing IDs for updates, invalid values, etc.).
	* Consider using transaction management where appropriate so bulk operations are handled safely.
	* The implementation should be clean, readable, and follow common Spring Boot best practices.

Testing is also important for this change.
Update or extend the existing ProductService unit tests to cover the new bulk operations. The tests should follow the current testing approach using JUnit and Mockito, mocking the repository and verifying the expected service behavior.

When generating the solution, include:
	* any additional DTOs required for bulk requests or responses
	* new methods in ProductService
	* repository updates if necessary
	* example controller endpoints that expose the bulk functionality
	* unit test examples extending the existing test structure

Make sure the solution integrates smoothly with the existing codebase and avoids unnecessary complexity.


## 3. Collaboration Approach

**How would you iterate and collaborate with the AI tool to implement this feature?**

1. Understand the existing project
   I would first ask GitHub Copilot to review the repository and suggest a simple design for implementing bulk operations that fits the current Spring Boot structure.

2. Design the request and response models
   Next, I would use Copilot to help define any additional DTOs needed for handling bulk requests and responses.

3. Implement the service logic
   I would then work with Copilot to implement bulk operations in `ProductService`, ensuring the logic uses efficient repository methods such as `saveAll()` and `deleteAllById()`.

4. Expose the functionality through endpoints
   After the service logic is ready, I would ask Copilot to generate controller endpoints that call the service methods while keeping business logic inside the service layer.

5. Extend unit tests
   Finally, I would update the existing `ProductService` unit tests to cover the new bulk operations using the same JUnit and Mockito approach already used in the project.
