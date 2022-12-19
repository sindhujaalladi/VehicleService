# VehicleService

spring cloud gateway and retry screen shots 
![image](https://user-images.githubusercontent.com/115841974/207994162-e7a0203c-46e9-4ed5-8fea-5d6cd53beb5f.png)


spring cloud gateway

![image](https://user-images.githubusercontent.com/115841974/207994751-5e0840d9-ee36-4ff9-a4e7-4c0a0e6ce7bd.png)

spring circuit breaker 
![image](https://user-images.githubusercontent.com/115841974/207995158-08713f9f-1448-44a6-aa3e-438a15613c1b.png)

feign client changes for getting land service info 
![image](https://user-images.githubusercontent.com/115841974/208024662-1e87053d-9bf7-45a3-bf91-56ec42e2ad90.png)

Added ELK stack and printed logs in logstash 

![image](https://user-images.githubusercontent.com/115841974/208264447-f914a915-104a-4393-80dd-c2c6dc5329bd.png)

logs generation path
![image](https://user-images.githubusercontent.com/115841974/208264561-af438439-bf5e-4fb2-abeb-427e2abaa526.png)


sleuth and zipkin tool
![image](https://user-images.githubusercontent.com/115841974/208344173-b2847c61-38fc-4085-9b11-3c44726dab54.png)

since trace id will be same across all microservices per request and here this is first microservice whch we are hitting so span and trace id will be same 
for registration trace id will be same and span id will gets changed for each microsevice 

![image](https://user-images.githubusercontent.com/115841974/208344288-2f824b9c-818f-4f27-bf9d-8d6d242115b2.png)

on zipkin tool
![image](https://user-images.githubusercontent.com/115841974/208344418-54b4ef94-aa40-4a48-acbc-f4264a14b6a4.png)

![image](https://user-images.githubusercontent.com/115841974/208344465-2f21baa9-b712-4ff9-ac1e-e941e2919a89.png)

u can check and cmpare with logs and tool 

with trace id check the logs in kibana 
![image](https://user-images.githubusercontent.com/115841974/208344844-167dc366-f898-420d-af3d-a483be863f5d.png)


