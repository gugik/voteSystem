##VotingSystem

REST API using Hibernate/Spring-Boot **without frontend**.

The task is:

Build a voting system for deciding where to have lunch.

 * 2 types of users: admin and regular users
 * Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
 * Menu changes each day (admins do the updates)
 * Users can vote on which restaurant they want to have lunch at
 * Only one vote counted per user
 * If user votes again the same day:
    - If it is before 11:00 we asume that he changed his mind.
    - If it is after 11:00 then it is too late, vote can't be changed

Each restaurant provides new menu each day.


Application is using H2 database stored in a file.  
Database schema will be updated automatically when application started.  

#### Installation
`mvn install`
#### Launching application
`java -jar target/VotingSystem-0.0.1-SNAPSHOT.jar`
#### Possible curl commands
For windows use `Git Bash`

#### Admin 
add new restaurant  
`curl -v -u admin@gmail.com:12345 -X PUT "http://localhost:8080/restaurant/" -d "name"="newRestaurant"`

if restaurant has no menu can delete it     
`curl -v -u admin@gmail.com:12345 -X DELETE "http://localhost:8080/restaurant/100027"`

see all restaurants     
`curl -v -u admin@gmail.com:12345 -X GET "http://localhost:8080/restaurant"`

can add new menu    
`curl -v -u admin@gmail.com:12345 -X PUT -H "Content-Type: application/json" http://localhost:8080/menu/ -d '{"date":"2017-06-20", "restaurantId":100003,"dishes":[{"name":"newDish", "price":28},{"name":"newDish2", "price":28},{"name":"newDish3", "price":28}]}'`

delete menu     
`curl -v -u admin@gmail.com:12345 -X DELETE "http://localhost:8080/menu/100005"`

see one menu with dishes    
`curl -v -u admin@gmail.com:12345 -X GET "http://localhost:8080/menu/one/100007"`

see menues with dishes by date  
`curl -v -u admin@gmail.com:12345 -X GET "http://localhost:8080/menu/findByDate/2017-06-10"`

like member of the staff can vote   
`curl -v -u admin@gmail.com:12345 -X PUT "http://localhost:8080/vote/100003"`

like member of the staff can change his vote    
`curl -v -u admin@gmail.com:12345 -X PUT "http://localhost:8080/vote/100002"`

see result vote by date     
`curl -v -u admin@gmail.com:12345 -X GET "http://localhost:8080/vote/resultByDay/2017-06-10"`


#### User

see one menu with dishes    
`curl -u user@yandex.ru:12345 -X GET "http://localhost:8080/menu/one/100009"`

see menues with dishes by date  
`curl -u user@yandex.ru:12345 -X GET "http://localhost:8080/menu/findByDate/2017-06-09"`

can vote    
`curl -u user@yandex.ru:12345 -X PUT "http://localhost:8080/vote/100004"`

can change his vote     
`curl -u user@yandex.ru:12345 -X PUT "http://localhost:8080/vote/100002"`

see result vote by date     
`curl -u user@yandex.ru:12345 -X GET "http://localhost:8080/vote/resultByDay/2017-06-09"`

