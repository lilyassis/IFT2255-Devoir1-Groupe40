# Feedback DM2

## Révision

- Il manque le nouveau CU "Consulter les entraves"

## Analyse

- Analyse absente.

## Diagramme de classes

- Il n'y a pas de classe principale Main ou MaVille. Mettre la fonction `menu()` dans la classe Utilisateur manque de 
cohérence. 
- Plusieurs classes font trop de choses en même temps. La connexion/inscription du résident/intervenant devrait se faire via une
classe comme AccountController au lieu de mettre ces méthodes directement dans ces deux classes car cela brise le principe
de responsabilité unique : La classe Resident ne devrait pas à la fois s'occuper de gérer les multiples CUs du résident
ET son inscription. 
- Une classe DatabaseController aussi aurait été utile pour gérer les opérations d'écriture/lecture des différentes
données de l'application. 
- Éparpiller les méthodes de `afficher__()` dans les différentes classes augmente fortement le couplage car ainsi 
les classes doivent appeler successivement et de manière imbriquée la fonction `afficher__()` des autres classes.
Une meilleure alternative est une classe Menu qui regroupe ces méthodes et est appelée via un MenuController 
dépendamment de l'input de l'utilisateur.

## Diagramme de séquence

- Les *alt* dépendamment de l'issue du `login` sont insuffisants car un échec de connexion devrait arrêter directement
le diagramme, et au contraire, c'est seulement quand la connexion est réussie que l'entièreté de la séquence peut être effectuée.
Ces blocs ne devraient pas seulement afficher un message de succès ou d'échec à l'utilisateur, car après c'est comme si le reste de la séquence
continuait, même si le login a échoué.
Il aurait fallu par exemple que le bloc alt \[connexion réussie\] contienne toute la séquence, mais qu'ensuite \[connexion échouée\] fasse juste quitter la séquence.
- `consulterEntraves()` devrait afficher quelque chose à l'utilisateur non?
- Filtrer les requêtes est optionnel et doit donc être inclus dans son propre *alt* bloc. 
- Les flèches doivent être mises de sorte à suivre l'ordre chronologique. Donc dans consulter requêtes, la flèche 1.1.2 devrait aller plus bas
que 1.1.1.1.3.1 par exemple. 
- L'input des données/paramètres par l'utilisateur n'est pas mise en évidence dans le diagramme. Par exemple, c'est 
`soumettreRequete()` appelée par Résident dans Requête qui doit contenir les paramètres, pas le soumettreRequete() que Requête appelle par elle-même.
Par ailleurs, cela ne fait pas de sens que Requête appelle soumettreRequête() sur lui-même avec des paramètres qui sortent de nulle part.

## Implémentation

- La déconnexion ne devrait pas complètement éteindre l'application.
- Après avoir soumis une requête avec un résident, elle n'apparaît pas quand je me connecte avec un intervenant et que je regarde la liste des requêtes.
- Aucun travail de vérification n'est fait pour s'assurer que la date inscrite pour la nouvelle requête de travail est correcte.
- La classe main semble faire l'entièreté de l'affichage. C'est difficilement maintenable.

## Tests unitaires

Très bien!

## Rapport et Git

Bien!