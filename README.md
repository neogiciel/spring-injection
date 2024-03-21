## <h1>Simple Spring-boot d'injection de dépendances</h1>
***
Un peu d'histoire
**Tout d'abord :**
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
**Les interfaces :**
Le java fournit un moyen de simplifier la gestion des dépendances : l'Interface. Les interfaces en java permettent de définir des méthodes et leurs paramètres sans en définir le code. Ces interfaces sont ensuites implémentées par les classes dont on dépend.
Ici, on crée une interface I définissant la méthode someMethod() et la classe A ne dépend donc plus de B directement mais de I qui peut être implémenté par n'importe quelle autre classe.

Cela se fait donc dans le code de A comme suit :
```
public class A {
   public static void main(String[] args) 
      I b = new B();
      b.someMethod();
   }
}
```

**Les Factories :**
Afin d'avoir du code java propre, la comunauté java à instauré des principes de programmations. Ces principes sont appelés des Design Pattern. Parmis ces design pattern on peut trouver le pattern factory. Ce pattern permet d'avoir une classe factory qui va gérer les dépendances. Cette factory possède des méthodes qui vont instancier la dépendance (ici B) et la retourner. Chaque fois qu'une dépendance devra être résolue (besoin d'un objet de type I) , la classe appelante utilisera la factory.

Cela se fait donc dans le code de factory comme suit :
```
public class factory {
   public I getDependency() 
      return new B();
   }
}
```

Et dans A :
```
public class A {
   public static void main(String[] args) {
      I b = new factory().getDependency();
      b.someMethod();
   }
}
```

**L'injection par constructeur :**
Les developpement d'applications java ayant besoin de plus en plus de tests, l'injection par factory ne suffit plus. Effectivement, cette dernière ne permet pas d'avoir une configuration de production et une configuration de tests. Une solution pour permettre de choisir le mode de lancement (configuration) est de passer l'implémentation directement dans le constructeur de notre classe (ici A)

Cela se fait donc dans le code de A comme suit :
```
public class A {
   I inst;

   public A(I inst) {
      this.inst=inst;
   }

   public void doWork() {
      inst.someMethod();
   }
}
```

Et dans la classe appelante :

```
public static void main(String[] args) {
   A a = new A(factory().getDependency());
   a.doWork();
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
Lancement de l'application Spring-boot<br>
```
$ mvn  clean
$ mvn spring-boot:run
```
Le service est accessible sur http://localhost:8088/test

## FAQs
***
**Aucune**





