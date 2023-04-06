# Quelques librairies de tests

[SQLite](https://www.sqlite.org/testing.html) est réputé pour avoir une proportion importante de tests.

## JUnit

Framework de test Java permet de tester son code via des assertions.
Explorons le projet de démarrage fourni par le [guide officiel](https://junit.org/junit5/docs/current/user-guide/)

### Exercices

1.  Ecrire un test unitaire `StringTest` qui test ces méthodes de la classe `String`: `toUpperCase()`, `toLowerCase()` et `charAt()`.
1.  Exo 2 de [cette série](http://deptinfo.cnam.fr/~graffion/UES/GLG101/tps/java/index.html)
    -   Ignorer les CE invalides b5 et b6
1.  Exercice 2 [de cette série](https://github.com/mjeanroy/exercices-java/blob/master/exercices-junit.txt) qui nécessite d'abord de faire d'abord ces exercices: [partie1](https://github.com/mjeanroy/exercices-java/blob/master/exercice-data-structures.txt), [partie2](https://github.com/mjeanroy/exercices-java/blob/master/exercice-data-structures2.txt)
1.  Cet [exo de librecours.net](https://librecours.net/module/js/js18/test-unitaire_app.xhtml). Le code est à traduire du JS vers du Java.
1.  Cet [exercice de librecours.net](https://librecours.net/module/js/js18/test-fonctionnel_app.xhtml). Le code est à traduire du JS vers du Java.
1.  Ce [TD qui provient de labri](https://www.labri.fr/perso/renault/working/teaching/testlog/files/td2.pdf). Le `makefile` est l'équivalent de `maven` pour nous. Faire la question 3 avec cette commande à la place de l'outil proposé `mvn surefire-report:report`.

??? Quelques astuces

    1. RàS
    1. Fonctions corriger / modifier: `checkDay`, `checkYear`, `checkDayLimits`, renommer ou enlever `maxDayOfMonth(month)`, `testFebruaryValidLimitDates`, `testValidLimitDates`

## Tests dans un projet Spring MVC

### API REST sans base de données

-   Générer un projet Spring avec [le créateur en ligne](https://start.spring.io/) en choisissant les dépendances suivantes: Spring Web et Spring Boot DevTools.
-   Ouvrir le projet sur VSCode
-   Créer un contrôleur avec deux routes en @GET et en @POST, un modèle et un service qui gère une liste statique en mémoire
-   Ecrire des tests unitaires pour le service
-   Spring propose deux façons de tester le contrôleur (en d'autres termes l'API REST).
    -   En lançant un serveur web (avec la stack HTTP complète) via la classe `RestTemplate`
    -   En lançant un serveur bouchonné (on n'a pas la stack HTTP complète) via la classe `MockMVC`
-   Ecrire des tests pour le contrôleur

### API REST avec une base de données

Nous allons utiliser la BDD H2 pour sa simplicité car c'est une BDD relationnelle (SQL) qui ne nécessite pas de serveur et réside en mémoire (RAM) par défaut.

-   Générer un projet Spring avec [le créateur en ligne](https://start.spring.io/) en choisissant les dépendances suivantes: Spring Data JPA, H2 Database, Spring Boot DevTool et Spring Web.
-   Ouvrir le projet sur VSCode
-   Créer une classe "Model" avec l'annotation `@Entity` et les annotations `@Id` et `@GeneratedValue` sur sa clé primaire.
-   Créer une interface `xxxxRepository: JpaRepository<Product, Long>` où xxx est le nom de votre modèle
-   Créer un contrôleur avec deux routes en @GET et en @POST, un modèle et un service qui gère communique ave votre repository

### Liens et références

-   http://deptinfo.cnam.fr/~graffion/UES/GLG101/tps/java/index.html
-   https://gayerie.dev/docs/testing/test/junit.html
-   https://github.com/mjeanroy/exercices-java/blob/master/exercices-junit.txt
