# Book_My_Show_backend

## About the Project:

1. This application is developed in Spring Boot 3.0.2 with the Maven build tool and Java 17. The database used is MySQL 8.0.31.

2. This project reflects the backend API structure, with multiple API layers and has arount 10 to 12 API s.

3. This project consists of models such as User, Ticket, Theater Seat, Theater, Show Seat,  Show, Movies.

4. This application allows users to search theaters for the required shows, book tickets for relevant shows, and get the price of movie booking.

5. The Database is maintained for all model Entities.

6. Exception Handling is done.Unit test cases are present for User Operations - User Registration and User Get. Cases for exceptions are also handled.

7. Dependencies used : 1.Spring Web   2. Spring Data JPA SQL   3.Lombok   4.MySQL Driver   5.swagger

## Author

Saggurthi Veera Phani

## Assumptions

For the simplicity of system, I have made following assumptions while implementing the solution -

1. Single User Model - One user will use at once. No locking implemented for seat selection.

2. Single Screen Theaters - No multiple screen handling for a theater has been done. However an option is given for future scope.

3. 10 seats for each show are configured - 5 for CLASSIC and 5 for PREMIUM. Seat numbers are kept fixed in all theaters.

4. No Payment flow used.

## API Details

1. UserController - API to add and get user.

2. TicketController - API to book ticket.

3. TheaterController - API to add and get theater.

4. ShowController - API to add show.

5. MovieController - API to add movie.

## Learnings from Project

1. Spring Boot Annotations
 
2. Different Layers of API
 
3. MYSQL DB connection
 
4. DB Designing

## Future Scope

1. Multiple Screen handling in theater

2. Payment Flow


