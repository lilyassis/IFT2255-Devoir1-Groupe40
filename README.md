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
Le répertoire est organisé comme suit : le dossier diagrammes contient tous les diagrammes 
UML, le dossier src contient le prototype de l'application avec le code source dans main/java
et les fichiers de test dans test/java, et le fichier rapport.html représente le rapport 
final du projet. 

## Description des données incluses dans l'application
Les données comprennent des profils d'utilisateurs (résidents et intervenants), des détails 
de projets et de requêtes de travaux, ainsi que des informations sur les entraves causées 
par les travaux.

## Instructions pour installer le projet complet 
Pour installer MaVille, assurez-vous que Java JDK 11+ et Maven sont installés. Clonez le dépôt avec git clone, naviguez dans le répertoire du projet, et exécutez "mvn clean install" pour compiler le projet et installer les dépendances.

## Instructions pour exécuter l'application
Après l'installation, pour lancer MaVille, ouvrez un terminal dans le répertoire racine et exécutez "java -jar target/MaVille.jar". Cela démarrera l'application et vous permettra d'accéder à ses fonctionnalités via l'interface en ligne de commande.

## Instructions pour exécuter les tests
Pour exécuter les tests unitaires, utilisez Maven avec la commande "mvn test", qui lancera 
automatiquement tous les tests configurés dans le projet.