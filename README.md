## Titre de l'application et brève description du projet
Le projet MaVille vise à améliorer la communication et la coordination entre les résidents 
et les intervenants de la ville de Montréal. L'application permet de consulter les travaux 
en cours, soumettre des requêtes de travaux, consulter les entraves, recevoir des notifications 
personnalisées et gérer les projets. Elle favorise une planification participative et minimise 
les impacts des travaux publics et privés sur la vie quotidienne des citoyens.

## Liste des fonctionnalités de l'application par rôle
Résident:
1. Créer un compte
2. Se connecter/déconnecter
3. Modifier ses préférences horaires
4. Voir ses notifications
5. Consulter les travaux en cours
6. Consulter les travaux à venir (3 prochains mois)
7. Chercher ou filtrer les travaux par quartier
8. Consulter les entraves engendrées par un travail
9. Chercher ou filtrer les entraves par rue
10. Soumettre une requête de travail
11. Faire le suivi d'une requête de travail
 
Intervenant:
1. Créer un compte
2. Se connecter/déconnecter
3. Consulter les requêtes de travail
4. Soumettre/Soustraire sa candidature
5. Faire le suivi de sa candidature
6. Soumettre un projet
7. Modifier le statut d'un projet

## Organisation des fichiers du répertoire
Le répertoire est organisé comme suit : le dossier diagrammes contient tous les schémas 
requis pour le rapport (cas d'utilisation, diagrammes d'activités, etc.), le dossier src 
contient le prototype de l'application avec le code source dans main/java et les fichiers 
de test dans test/java, et le fichier rapport.html représente le rapport final du projet. 

## Description des données incluses dans l'application
L'application est initialisée avec 5 résidents, dont deux habitent dans le même quartier, 
5 intervenants aux types variés, 5 requêtes de travail, incluant deux avec des candidatures, 
et 5 projets, dont au moins un prévu dans les trois prochains mois. Les données proviennent 
des APIs publiques de Montréal, notamment la liste des travaux en cours et la liste des entraves 
causées par les travaux.

## Instructions pour installer le projet complet 
Pour installer le projet, il est nécessaire d'avoir Java 17 ou une version ultérieure, 
Maven pour la gestion des dépendances et un IDE tel qu'IntelliJ IDEA. Les étapes d'installation 
sont les suivantes : commencez par cloner le dépôt GitHub avec la commande git clone suivie du 
chemin du projet, puis déplacez-vous dans le répertoire avec cd. Ensuite, compilez le projet en 
utilisant Maven avec la commande mvn clean install, et enfin, importez le projet dans votre IDE 
pour le développement ou l'exécution.

## Instructions pour exécuter l'application
Pour exécuter l'application, ouvrez votre IDE et lancez la méthode runApplication() située dans 
la classe Main. Une interface en ligne de commande s'affichera pour permettre aux utilisateurs 
d'interagir directement avec l'application et de naviguer dans les différentes fonctionnalités 
offertes.

## Instructions pour exécuter les tests
Pour exécuter les tests unitaires, utilisez Maven avec la commande mvn test, qui lancera 
automatiquement tous les tests configurés dans le projet.