## <h1>Simple Spring-boot d'injection de dépendances</h1>
***
*Tout d'abord :*
Lors de la séparation d'un code en plusieurs classes, nous avons une dépendance directe d'une classe a une autre. Nous séparons le code général en une classe A et une classe B. La classe A doit utiliser une méthode de la classe B.

Cela se fait donc dans le code de A comme suit :
```
public class A {
   public static void main(String[] args) 
      B b = new B();
      b.someMethod();
   }
}
```


## Informations Générales
***
Mise en place d'une Gateway qui s'appuit sur la solution Spring Cloud Gateway
## Technologies
***
Technologies utilisées:
* Java 17 
* Maven 3.6
* Spring-boot: 3.2
## Instalation
***
Configuration de la route
```
 @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {

        logger.info("[Service GW Springboot] SpringCloudConfig : gatewayRoutes");

        return builder.routes()
                .route(r -> r.path("/security")
                        .uri("http://dev2.neogiciel.com"))

                .build();
    }
```
Lancement de l'application Spring-boot<br>
```
$ mvn  clean
$ mvn spring-boot:run
```
Le service est accessible sur http://localhost:8088

## FAQs
***
**Présentation de la Spring Cloud Gateway**
* https://spring.io/projects/spring-cloud-gateway




