# Travel  Agency

Travel Agency est une application Web écrite en Jakarta EE pour la gestion d'une agence de voyage.

## Installation

* Configurer sa base de données dans le fichier _resources\hibernate.cfg.xml_.

* Insérer les tables et données dans la base de données avec le fichier _resources\datainit.sql_.

## Fonctionnalités

* Les employés peuvent administrer les offres de voyage (Ajouter/Éditer/Supprimer), les employés et les clients peuvent réserver des offres de voyage.

* Les clients peuvent se créer un compte.

* L'application contrôle s'il reste des places disponibles et fournit le prix à payer à la suite d'une réservation.

* Le diagramme de classe/MVC se trouve dans le fichier _resources\ClassDiagram.png_.

## Choix

* Nous avons décidé de ne pas traiter les réductions par tranche d'âge.

* Nous avons décidé de fusionner les deux classes _offre_ et _destination_ pour plus de simplicité.

* Nous avons décidé de ne pas traiter le temps partiel/temps plein des employés.

### Étudiants
Pier-Hugo CARPENTIER - Erwann PIEDLOUP