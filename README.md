# BookClub Online Bookstore #

BookClub is an online bookstore application built with Spring Boot. It allows users to browse books, add them to a cart, and manage their accounts.

## Submitted by: ##
- Hadar Liel Harush - 211721568
- Lior Yakobovich - 207258625


## Functionality ##

- User Registration and Authentication
- Book Browsing and Searching
- Shopping Cart Management
- Book Management (adding new books)

## Features

1. **User Management**
    - User registration with validation
    - User login and logout
    - Password encryption using BCrypt

2. **Book Management**
    - Display list of books with cover images
    - View book details
    - Filter books by type
    - Add new books (including cover image upload)

3. **Shopping Cart**
    - Add books to cart
    - Remove books from cart
    - View cart contents and total price

4. **Security**
    - Form-based authentication
    - Session management

## How to Run

### Prerequisites

- Java JDK 22
- Maven
- MySQL

### Database Setup

1. Create a new MySQL database named `bookdb`
2. The application.properties file is already configured to use:
    - Username: root
    - Password: (empty)
    - If your MySQL setup is different, update these in the application.properties file

### Running the Application

1. Clone the repository
2. Navigate to the project directory
3. Run `mvn spring-boot:run`
4. Open a web browser and go to `http://localhost:8080`

### Initial Data

The application uses `spring.jpa.hibernate.ddl-auto=create-drop`, which means the database will be recreated each time the application starts. You'll need to add books through the interface after starting the application.

## Additional Notes

- The application uses Thymeleaf for server-side rendering
- Bootstrap is used for frontend styling
- Static resources (CSS, JavaScript, images) are served from the `/static` directory
- Book cover images are stored in the `/static/images` directory

## Known Limitations

- There is no specific admin role or admin functionality
- The add book form is accessible to all authenticated users

## Data Management

### Database (MySQL)
The following data is stored and managed in the MySQL database:

1. **Users**: User account information including username, email, and hashed password.
2. **Books**: All book details including title, author, price, description, type, and cover image URL.

### Session
The following data is managed using session storage:

1. **Authentication**: User login status is maintained in the session.
2. **Shopping Cart**: The user's current shopping cart contents are stored in the session. This includes:
    - List of books added to the cart
    - Quantity of each book (if applicable)
    - Total price of items in the cart


## Video: ##
### Link to the presentation: ###
https://drive.google.com/file/d/1_F-psCJkjp8lKhaBgctWkuNRxki1z9UV/view?usp=sharing