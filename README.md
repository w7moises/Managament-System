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
│   │   │               │   └── audit
│   │   │               │       └── SpringSecurityAuditorAware.java
│   │   │               │   └── auth
│   │   │               │       ├── ApplicationConfig.java
│   │   │               │       ├── JwtAuthenticationFilter.java
│   │   │               │       └── SecurityConfig.java
│   │   │               │   ├── JwtService.java
│   │   │               │   └── LogoutService.java
│   │   │               ├── controller
│   │   │               │   ├── StudentController.java
│   │   │               │   └── AuthenticationController.java
│   │   │               ├── dto
│   │   │               │   └── auth
│   │   │               │       ├── AuthenticationRequest.java
│   │   │               │       └── AuthenticationResponse.java
│   │   │               │   ├── StudentDto.java
│   │   │               │   └── UserDto.java
│   │   │               ├── entity
│   │   │               │   └── auth
│   │   │               │       ├── Token.java
│   │   │               │       └── TokenType.java
│   │   │               │   ├── Auditable.java
│   │   │               │   ├── Role.java
│   │   │               │   ├── Student.java
│   │   │               │   └── User.java
│   │   │               ├── exception
│   │   │               │   ├── ErrorDetails.java
│   │   │               │   ├── EmailExistsException.java
│   │   │               │   ├── ResourceNotFoundException.java
│   │   │               │   └── GlobalExceptionHandler.java
│   │   │               ├── repository
│   │   │               │   ├── StudentRepository.java
│   │   │               │   ├── TokenRepository.java
│   │   │               │   └── UserRepository.java
│   │   │               └── service
│   │   │                   ├── impl
│   │   │                   │   ├── StudentServiceImpl.java
│   │   │                   │   └── AuthenticationServiceImpl.java
│   │   │                   └── StudentService.java
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