# SwaggerExemple

# Introducing API Documentation with SpringDoc

This project serves to illustrate an approach to API documentation following the Swagger standard, using the SpringDoc library. It's worth noting that despite its name, SpringDoc is not part of the Spring Boot ecosystem.

# Initial Configuration

The entire documentation has been neatly organized within a dedicated configuration class, accompanied by an interface that outlines a contract with the class providing the API endpoints. Furthermore, Data Transfer Objects (DTOs) have been annotated to offer comprehensive information.

# Configuration in pom.xml

To integrate SpringDoc into your Spring project, you need to add the following dependency to your "pom.xml" file:

```
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.2.0</version>
</dependency>

```
SpringDocConfiguration Class

Within the "core" directory of the project, you'll find the "SpringDocConfiguration" class, which houses all the configurations related to the OpenAPI bean. This class defines crucial information like the title, version, and description of your API. Additionally, it represents the "ProblemDetail" within the documentation. While you can configure endpoints in this class, it's preferable to separate them into an interface for improved code readability and maintenance.

# Endpoint Documentation

Endpoint documentation is organized in an interface named "DocumentControllerSwagger," situated in the "controller/openapi" package. This interface is implemented by the "DocumentController" class. By adding documentation annotations to the interface, we keep the controller code cleaner, and any changes to the documentation do not necessitate modifications to the controller.

# Documentation Annotations

Within the interface, we employ the following documentation annotations:

@Tag: This annotation groups operations (controller methods) into categories or tags within the documentation, aiding in the organization and categorization of related operations.

@Operation: This annotation describes specific operations within a REST controller, such as methods that handle HTTP requests. It offers detailed information about the operation, including descriptions, summaries, and parameters.

@ApiResponse: This annotation defines the responses an API operation can generate. This includes the HTTP response code, a response description, and optionally, response examples. It is useful for specifying the types of responses clients can anticipate when calling a specific operation.

# Annotations in DTOs

The examples of JSON input/output responses for each class are specified within the annotations of the DTOs. In this project, DTOs are implemented as "records" and reside in the "domain/dto" folder.

@Schema: This annotation is used to document classes and fields in a REST API. It assists in describing the structure of the data transmitted within the API, providing information such as descriptions and examples.

This is a concise overview intended to help beginners embark on this documentation journey. However, it's crucial to emphasize the significance of referring to the comprehensive SpringDoc documentation. There are various ways to execute documentation, and this project serves as a valuable reference point.
