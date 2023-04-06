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

### Tests dans un projet Spring MVC

-   Générer un projet Spring avec [le créateur en ligne](https://start.spring.io/) en choisissant les dépendances suivantes: Spring Web et Spring Boot DevTools.
-   Ouvrir le projet sur VSCode
-   Créer un contrôleur avec deux routes en @GET et en @POST, un service et un modèle
-

### Liens et références

-   http://deptinfo.cnam.fr/~graffion/UES/GLG101/tps/java/index.html
-   https://gayerie.dev/docs/testing/test/junit.html
-   https://github.com/mjeanroy/exercices-java/blob/master/exercices-junit.txt
