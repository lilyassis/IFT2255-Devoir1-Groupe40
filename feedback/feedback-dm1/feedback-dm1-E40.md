# Feedback DM1 

Disclaimer : Tout ce qui est mentionné dans le feedback sont les points et les détails à améliorer. Si des aspects du devoir n'ont pas été critiqués, c'est qu'ils sont déjà bons.

## Glossaire

- Il manque la définition de l'application MaVille, code de la ville, les problèmes et types de problèmes rencontrables dans le cadre de l'application.

## Diagramme de CUs

- Un intervenant ne peut pas forcément faire toutes les actions qu'un résident peut faire, la généralisation ne marche pas ici. Ce sont deux entités distinctes. Une généralisation qui marche aurait été que le résident et l'intervenant héritent d'un utilisateur qui peut juste se connecter, optionnellement modifier son profil et consulter ses notifications.
- Mettre à jour les informations d'un chantier n'est pas une extension de Soumettre un projet car ce sont deux actions fondamentalement différentes.
- Il n'y a pas de raison d'extend "Participer à la planification des travaux" à "Consulter les travaux en cours ou à venir". L'inverse ferait plus de sens.
- "Participer à la planification des travaux" est un cas d'utilisation trop abstrait car il est déjà fait indirectement par plusieurs cas d'utilisation concrets comme "Soumettre une requête de travail" et "Consulter les travaux en cours ou à venir". Il vaut mieux faire juste simple et supprimer ce CU et directement relier les CUs concrets au résident.
- Il manque "Permettre une planification participative".

## Scénarios

- Les scénarios alternatifs sont mal annotés. Par exemple, il n'y a pas d'étape 9 ni 10 dans le scénario principal de "S'inscrire comme résident". La bonne notation aurait été "8a" et "8b". Et c'est pareil dans tous les autres scénarios alternatifs.
- Le scénario alternatif de problème de connexion à Internet est un peu lourd car soit vous le citez comme une alternative possible à chaque étape de chaque scénario, soit vous ne le mentionnez pas et vous supposez que si l'utilisateur arrive à ouvrir et se connecter à l'application, alors il ne devrait pas avoir de problèmes de connexion après ça.
- Le fait de se connecter à son compte dans l'application ne peut pas être à la fois une précondition et une action explicite dans le scénario principal. Vous avez choisi de la mettre en <<include>> dans tous les CUs donc ça doit être seulement une action explicite du scénario.

## Diagramme d'activités

- Un branchement de noeud de décision ne peut pas emmener directement à un ancien noeud de décision car il devrait encore y avoir une action à faire pour savoir où va emmener la prochaine décision.
- Même si on ne fait pas de diagramme d'activités pour les intervenants, il faut quand même montrer que l'utilisateur a le choix entre s'inscrire en tant que résident ou intervenant lorsqu'il ouvre l'application.
- Il manque un noeud de fusion et un noeud de fin d'activité après les 5 actions dans le diagramme principal. Il faut toujours qu'ensuite on sache où se terminerait l'activité entière.
- Il manque le nom de la décision et des branchements dans plusieurs noeuds de décision de vos diagrammes, ce qui les rend beaucoup plus durs à comprendre.

## Analyse

### Risques

- La justification pour "Mise à jour du site lente" ne met pas suffisamment en valeur le risque fonctionnel que ça peut avoir (risque de fausses informations sur les chantiers entre autres).
- Le titre "Système de contrôle" n'est pas approprié à un risque comme celui que vous décrivez.

### Besoins non-fonctionnels

- Certains de ces besoins fonctionnels manquent de justification contextuelle spécifique à l'application. On aurait pu dire par exemple que le besoin de fiabilité permet d'avoir le service de notifications de travaux ouvert 24h/7j et que les serveurs sont surveillés en permanence pour assurer les fonctionnalités du service.

### Besoins matériels

- Il faut aussi estimer les coûts d'un tel choix d'hébergement de services.

### Solution de stockage 

- Il faut aussi parler du type de base de données que vous voulez utiliser (relationnelle ou non relationnelle), les mesures de sécurité pour protéger ces données, et un exemple concret qui illustre cette solution.

### Solution d'intégration

- Il n'y a aucune explication pour les intégrations proposées, ni d'exemple pour illustrer cette solution.

## Prototype

Bien!

## Git 

Bien!

## Rapport

Bien!