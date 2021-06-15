"# springboot-demo" 

This is a spring boot application to demonstrate how to import the data from file via the spring batch and stored into DB. Able to be query via Restful API. The results is paginated.

The standard component in spring batch (activity diagram)
![img_3.png](img_3.png)

Basic class diagram for spring batch
![img_5.png](img_5.png)

Class diagram for rest component
![img_6.png](img_6.png)

<b>Restful API:</b>

This application provide 2 type of rest api, One is define via
@RepositoryRestResource, another is via @RestController

@RepositoryRestResource will create a HATEOAS service with spring JPA. HATEOAS provide pagination and search function.

@RestController will not create a HATEOAS,pagination and search are done in repository object.

<b>Rest API for @RepositoryRestResource</b><br>
1.HATEOS top level service<br>
http://localhost:8080/

2.To see all customer records<br>
http://localhost:8080/custTrx{?page,size,sort}"

3.Info for search option<br>
http://localhost:8080/custTrx/search

4.To search by customer id<br>
http://localhost:8080/custTrx/search/findByCustId{?custId,page,size,sort}

5.To search by account number<br>
http://localhost:8080/custTrx/search/findByAccNumber{?accNumber,page,size,sort}

<b>Rest API for @RestController</b><br>
1. Retrieved all customer<br>
http://localhost:8080/customers/{?page,size,sort}
   

2. Search by customer id<br>
http://localhost:8080/customers/custId{?custId, page,size,sort}
   

3. Search by account number<br>
http://localhost:8080/customers/accNo{?accNumber, page,size,sort}
