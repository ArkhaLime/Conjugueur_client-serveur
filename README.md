# Conjugueur_client-serveur
Projet en Java avec l'utilisation du design pattern "chain of responsibility" et interface graphique

## Conjugueur_Commun
Ce projet contient les parties en commun pour les projets Conjugueur_Client et Conjugueur_Serveur. Ces deux projets ont un lien vers le jar pour permettre son utilisation
* Message_Client et Message_Serveur, classe qui contient les différentes informations qui circule entre le client et le serveur
* Un Logger assez simple (seulement utiliser dans le serveur)
* Une énumération avec les différents temps reconnus

## Conjugueur_Serveur
Ce projet est un serveur multi-clients
* "Chain of responsibility" pour la création de l'objet Verbe
* "Chain of responsibility" pour la création de l'objet Temps qui permet de conjuguer le verbe au bon temps
* Pas encore de possiblité de l'arrêter sans tuer le processus

## Conjugueur_Client
Ce projet est un client graphique qui se connecte sur le serveur
* Possibilité de se connecter à différents serveurs grâce à un champ adresse et port
* Possibilité d'écrire un verbe un l'infinitif dans un champs texte
* Possibilité de choisir le temps voulu grâce une liste déroulante
