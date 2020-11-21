# Secure a Spring Boot Application with TLS

## Pre-steps
* Create a Spring boot project with web, h2, data-jpa and Lombok dependencies.
* In [application.yml](src/main/resource/application.yml), configure h2 in-memory database.
* Use [api.book.httpie](src/test/java/br/dev/sam/secureresttls/api.book.httpie) file to run HTTPie tests.


## Creating the certificate (self-signed)

* Use keytool (in JDK_HOME/bin) command to generate the certificate:
```bash
 keytool -genkey -keyalg RSA -alias sec-rest-tls -keystore sec-rest-tls.jks -storepass ssssss -validity 365 -keysize 4096 -storetype pkcs12
```
* Copy the certificate to src/main/resource.
* Add the configurations in [application.yml](src/main/resource/application.yml) to enable TLS.
* Testing the API:
```bash
https://localhost:8443/v1/books/1
```
* Many HTTP clients have a check on the Self-Signed certificates and it does not allow accessing resources over Self-Signed certificates HTTPS. Try use Postman. 

### Reference
* [Somnath Musib post in Medium](https://medium.com/swlh/how-to-secure-a-spring-boot-application-with-tls-176062895559)
