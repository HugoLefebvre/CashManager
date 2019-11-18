# The API 

## Requirement
### Software
```
- Spring boot (http://spring.io/)
```
## Configuration

in Database/Datebase.java you can change your credentials databases.

***If database doesn't exist then it will be created***
#### First running

`./$> mvn spring-boot:run`  if you have some error it is normal, stop en re run`
## Endpoints

### [](https://github.com/antoinefepitech/TimeManager#swagger)Swagger

Swagger is available at  [http://localhost:8080/api-docs/](http://localhost:4000/api-docs/).

## Product
**GET**

- List of all registered  products : [http://localhost:8080/product/all](http://localhost:8080/product/all)
- Product matching the id : [http://localhost:8080/product/id](http://localhost:8080/product/id)
- Product matching the code :  [http://localhost:8080/product/code](http://localhost:4000/product/code)
	
**POST**

- Add a new product :  [http://localhost:8080/product?pCode=XXX&name=YYY&prix_unit=ZZZ](http://localhost:8080/product?pCode=XXX&name=YYY&prix_unit=ZZZ)]
	   
**DELETE** :

- Delete a product :  [http://localhost:8080/product/id](http://localhost:8080/product/id)]
	  
**PUT**
-   Update product by id /product http://localhost:8080/product/id]
## _USER_
