# restaurant_service
Spring Boot and Hibernate Implementation. Application provides the following API endpoints:
1. Batch Service: http://<host>:9999/restaurant-service/batch/fetchRestaurants?city=Chicago&page=1&page_size=100
   This API fetches data from an Open Source API (http://opentable.herokuapp.com/api/restaurants) and stores them into MySQL. 
2. Restaurant Details API: 
   http://<host>:9999/restaurant-service/restaurants?city=Chicago&page=0&page_size=10&responseType=json  
   This API fetches data from MySQL and delivers them in JSON/XML format. For getting the data in XML format, please specify      the responseType=xml in the URL parameter.
  
More to come on this..........
