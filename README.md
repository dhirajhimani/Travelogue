# Travelogue



An application for travel plans

- Create an account and log in.
- Logged in, a user can see, edit and delete trips he entered.
- Implemented three roles with different permission levels: a regular user would only be able to CRUD on their owned records, a user manager would be able to CRUD users, and an admin would be able to CRUD all records and users.
- A trip has Destination, StartDate, EndDate, Comment.
- Each entry also has day count to trip start (only for future trips).
- User can filter trips.
- Print travel plan for next month.
- REST API. Make it possible to perform all user actions via the API, including authentication (If a mobile application and you don’t know how to create your own backend you can use Firebase.com or similar services to create the API).
- This project explains how a REST API works and demonstrate that by creating functional tests that use the REST Layer directly. 
- added unit and e2e tests.



Current Reository contains :-

1. TravelogueService - This holds the rest api service for the users and trips created by them, with CRUD operations.
2. TravelogueApp- This contains the client app in android to use the rest apis provided by the service and perform the require operations.


Tech Stack:-

1. Scala
2. Java
3. Play Framework
4. Slick
5. Room
6. Postgre
7. Android SDK

