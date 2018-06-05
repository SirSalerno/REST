# Restful CRUD webapp with JPA

Maven and a free 8080 port are necessary to run this project.
The command "mvn test" can be used at the root directory to run Maven's tests before starting the application.
To start the webapp, simply run "mvn tomcat:run" at the root directory.

REST commands:

GET    http://localhost:8080/RESTfulCRUD/rest/products ===============================> Lists all products (excluding relationships)

GET    http://localhost:8080/RESTfulCRUD/rest/products/{id} ==========================> Lists the product that corresponds to the given id

POST   http://localhost:8080/RESTfulCRUD/rest/products ===============================> Inserts product

PUT    http://localhost:8080/RESTfulCRUD/rest/products ===============================> Updates product

DELETE http://localhost:8080/RESTfulCRUD/rest/products/{id} ==========================> Deletes the product that corresponds to the given id

GET    http://localhost:8080/RESTfulCRUD/rest/images ===============================> Lists all images (excluding relationships)

GET    http://localhost:8080/RESTfulCRUD/rest/images/{id} ==========================> Lists the image that corresponds to the given id

POST   http://localhost:8080/RESTfulCRUD/rest/images ===============================> Inserts image

PUT    http://localhost:8080/RESTfulCRUD/rest/images ===============================> Updates image

DELETE http://localhost:8080/RESTfulCRUD/rest/images/{id} ==========================> Deletes the image that corresponds to the given id

Unfortunately, I couldn't manage to use Hibernate annotations to create the relationships between the objects.
When I tried to do this, the mapping entered in a loop, so I decided to keep the "foreign keys" as simple class attributes.
I couldn't list the objects relationships either.  
