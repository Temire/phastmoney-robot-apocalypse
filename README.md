# PhastMoney Robot Apocalypse Coding Challenge
##### Temire Emmanuel Attempt 

#

##HOW TO RUN
To run the applications simply run the command:

`mvn spring-boot:run`
 
All endpoints are authenticated by JWT on the Authentication endpoint. Add the token generated to the Authorization header like this:

`Bearer <your-generated-token>`


##ENDPOINTS

###Survivor
- Add Survivor [POST]: http://<your-ip>:8082/phastmoney/apocalypse/survivor/save

  `Payload => {
  "firstName": "",
  "lastName": "",
  "gender": "",
  "location": {
  "longitude": 0.00,
  "latitude": 0.00
  },
  "age": 0
  }`


- Get Survivors by InfectionStatus [POST] : http://<your-ip>:8082/phastmoney/apocalypse/survivor/report-infection/{infectionStatus}
     
  `Statuses => INFECTED,
  NON_INFECTED`


- Update Survivor Info [PUT]: http://<your-ip>:8082/phastmoney/apocalypse/survivor/update/{survivorId}

  `Payload => {
  "longitude": 0.00,
  "latitude": 0.00
  }`

###Robot
- Get Robots [GET]: http://<your-ip>:8082/phastmoney/apocalypse/robots

###Infection Record
- Report Infection Survivor [POST]: http://<your-ip>:8082/phastmoney/apocalypse/report-infection/save

  `Payload => {
  "reportedById": 0,
  "survivorReportedId": 0,
  "dateReported": "2023-02-15 14:28:46"
  }`

###Inventory
- Add Inventory [POST]: http://<your-ip>:8082/phastmoney/apocalypse/inventory/save

  `Payload => {
  "survivorId": 0,
  "inventoryType": "FOOD",
  "quantity": 0,
  "activeStatus": false
  }`


- Update Inventory [PUT]: http://<your-ip>:8082/phastmoney/apocalypse/inventory/update/{inventoryId}

  `Payload => {
  "survivorId": 0,
  "inventoryType": "FOOD",
  "quantity": 0,
  "activeStatus": false
  }`


- Get Survivor Inventory [GET]: http://<your-ip>:8082/phastmoney/apocalypse/inventory/get-by-survivor/{survivorId}

###Swagger Url
  - http://<your-ip>:8082/swagger-ui/index.html#/

###Authentication
- [POST] http://<your-ip>:8082/phastmoney/apocalypse/security/auth

  `Payload => {
  "username": "phastmoney",
  "password": "apocalypse"}`
   `**Use the above credentials`
   
 

#

*Thanks for the opportunity!*
