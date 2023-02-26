# Managament-System

## Project Structure
```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── management
│   │   │           └── app
│   │   │               ├── ManagementApplication.java
│   │   │               ├── config
│   │   │               │   └── WebConfig.java
│   │   │               ├── controller
│   │   │               │   └── UserController.java
│   │   │               ├── dto
│   │   │               │   └── UserDto.java
│   │   │               ├── entity
│   │   │               │   └── User.java
│   │   │               ├── exception
│   │   │               │   ├── ErrorDetails.java
│   │   │               │   ├── EmailExistsException.java
│   │   │               │   ├── ResourceNotFoundException.java
│   │   │               │   └── GlobalExceptionHandler.java
│   │   │               ├── repository
│   │   │               │   └── UserRepository.java
│   │   │               ├── service
│   │   │               │   └── UserService.java
│   │   │               └── util
│   │   │                   └── SecurityUtil.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── static
│   │       └── templates
│   └── test
│       └── java
│           └── com
│               └── management
│                   └── app
│                       └── ManagementApplicationTests.java
```
[INFO] ------------------------------------------------------------------------