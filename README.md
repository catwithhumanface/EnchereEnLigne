
# ABOUT PROJECT
#### [ Enchères en Ligne ] Développement d'une application en Java : Application des enchères en ligne (Inscription, Connexion, Gestion des membres, Gestion des ventes, Gestion des statistiques <br><span style="font-size:15px">*( 2021.10.14 ~ 2021.10.21 )*</span>

## 1. Membres de l'équipe

|*Members*|*Contact*|
|:---:|---|
|**Joohyun ANN**|[![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white)](http://github.com/catwithhumanface) [![Gmail Badge](https://img.shields.io/badge/-annjh11@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:annjh11@gmail.com)](mailto:annjh11@gmail.com)|
|**Tong LIU**|[![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white)](https://github.com/Gabrielle07) [![Gmail Badge](https://img.shields.io/badge/-tongliu024@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:tongliu024@gmail.com)](mailto:tongliu024@gmail.com)|
|**Annie DAGO**|[![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white)](https://github.com/Annie-create) [![Gmail Badge](https://img.shields.io/badge/-Lielyannie@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:Lielyannie@gmail.com)](mailto:Lielyannie@gmail.com)|

## 2. Installation du projet
1. Copier Code Github 
2. Import Projet
3. Connexion DB to MySQL
   1. Exécution SQL (DB.sql)
   2. Adapation de connexionBD.php
      1. dbname
      2. username
      3. password
4. Exécution de l'application
   
## 3. Présentation du projet
Afin de répondre aux besoins exprimés de client, qui souhaite avoir une application des enchères en ligne, nous avons réalisé la modélisation et la programmation de l'application "Enchères en Ligne". Ce projet a été accompagné des enseignants de la formation M2 MIAGE IPM. <br>


&nbsp; Nous avons donc modélisé et réalisé une application permet de **mettre en vente** d'un objet, **enchérir sur un objet en vente**, ainsi que **s'inscrire, se connecter, et les autres fonctionnalités adapté aux types de l'utilistaeur**.

## 4. Technologie
UML<br>
Java<br>
Java Swing<br>
MySQL<br>

## 5. Modélisation DCL
![DCL](img/dcl.png)
<br>

## 5. Structure du système (MVC pattern)
![structure2](img/structure2.png)
<br>

![structure1](img/structure1.png)
<br>

# Results
## 1. Résultat
### *Gestion des Membres*
![ConnexionClient](img/connexionClient (1).gif)
<br>

---

![ConsulterMesParticipations](img/consulterMesparticipations.gif)
<br>
&nbsp; **Connexion**, **Consulter les enchères en cours**, **Enchérir sur un objet**, **Consulter mes participations**

---


![ConnexionServiceClient](img/connexionServiceCommercial.gif)
<br>
&nbsp; **Connexion**, **Consulter les enchères en cours**, **Consulter les statistiques**

---

![InscriptionClient](img/inscriptionClient.gif)
<br>
&nbsp; **Inscription*


### *Gestion des Ventes*

![EncherirClient](img/EncherirClient.gif)
<br>
&nbsp; **EncherirClient**

---

![MiseEnVenteMembre](img/MiseEnVenteMembre.gif)
<br>
&nbsp; **MiseEnVenteMembre**
Se connecter étant que « membre », réaliser une mise en vente


![MiseEnVenteMembrePlus](img/MiseEnVenteMembrePlus.gif)
<br>
&nbsp; **MiseEnVenteMembrePlus**
Se connecter en tant que « membre plus », réaliser une mise en Vente

---

### *Gestion des Statistiques*
![ConsultationStats](img/ConsultationStats.gif)
<br>
&nbsp; **ConsultationStats*

---


## 2. Défis
 - **Modélisation** : 
 - Diagramme de Classe prévu
 ![DCLPrevu](img/dcl.png)
<br>
 - Diagramme de Classe réalisé
 ![DCLActuel](img/DCLActuel.jpg)
<br>
    &nbsp;La base de données devait au mieux représenter les informations par rapport au **besoin exprimé**, qui était donc de mettre en place un site fonctionnel et interactif entre les propriétaires de chiens et des gardiens, professionnels ou particuliers, ou d'autres propriétaires. Il a donc fallu **reflechir à la structure** de la Base de Données afin de pouvoir enregistrer chaque information nécessaire à **l'exploitation et le lien au site web.**
<br><br>En effet, ne connaissant que peu de langages de Bases de Données, nous avons tout d'abord dû décider duquel utiliser afin de faciliter au plus la connexion avec le Site web. Ayant choisi **MySQL Workbench**, nous nous sommes rapidement lancés dans sa création. Mysql est similaire à Oracle, mais le langage n'est pas pas exactement le même. La difficulté était donc d'adapter nos scripts dans le bon langage, par apprentissage numérique de ce dernier et de son environnement. En raison du manque de cours MySQL clairs, certains problèmes sont survenus pendant ce processus de conversion.<br><br>Par la suite, une **insertion de données** dans la BD était nécessaire par rapport aux informations qui devaient être présents sur le site, notamment ceux des chenils. Pour cela, nous avons utilisé l'outil "web scaper" pour obtenir des données. La plus part du temps, les bases de données n’était pas accessibles et il fallait passer par l’administrateur du site pour pouvoir récolter les données. Néanmoins, pour certains sites Web, ses sections sont reguliers, et l'acquisition de données est autorisé et facile. Cependant, certains sites Web ont des sections confus alors on ne peut pas utiliser le "web scraper" pour **obtenir automatiquement des données**. Cela nous oblige à les **compléter manuellement**, ce qui prend beaucoup de temps. Un autre problème rencontré était par rapport à **l'abondance et répétitions de donées** entre différents sites Web, Cela nous oblige à les trier et à les filtrer manuellement.<br><br>Finalement, par la mise en place d'un groupe interdisciplinaire et grâce à l’implication de chacun, nous avons réussi à mettre en place une base de données facile à gérer, favorisant la transparence et la qualité de l’information.<br><br>

 - **Base de données** : 
    &nbsp;La base de données devait au mieux représenter les informations par rapport au **besoin exprimé**, qui était donc de mettre en place un site fonctionnel et interactif pour la processus complète de la mise en chère. Il a donc fallu **reflechir à la structure** de la Base de Données afin de pouvoir enregistrer chaque information nécessaire pour garantir les fonctionnalitées désirée par les utilisateurs. 

<br><br>Au niveau de structure, nous avons bien respecté la format 3NF qui nous permet d'éviter les redonnance, mais cela aussi lourdir l'execution des requêtes pour la suite. En plus, nous faison souvent les requêtes "select", ce qui demande des jointures entre les table ou encore une requête afin de renvoyer l'identifiant à conserver.
<br><br>Au niveau de la connection avec programmation java, en raison du manque de connaissance sur l'environnement et la path, la problème de connexion est survenue pendant notre test.
<br><br>Au niveau de l'insertion de données, nous avons peu de connaissance sur la structure de données et cela pose certains problèmes quand nous récupèrons les données via la programmation java.
    
- **Application** : 
    
    &nbsp;Notre objectif était de créer un site qui présente clairement les services que PETCARE propose (au niveau du Front-end). Il s'agissait de les faire fonctionner correctement dans le langage PHP & HTML, avec des outils comme **API OpenStreetMap, Bootstrap, Javascript, et JQuery (au niveau du back-end).** En ayant eu peu d'expérience dans la création de site web pour certains membres, il était donc nécessaire d'être avide de connaissances et d'appliquer les apprentissages des cours de Site Web et de Programmation Structurée.<br><br>En effet, en réalisant le projet, nous avons rencontré quelques difficultés, notamment par rapport à l'utilisation du langage PHP, qui était nouveau pour certains membres de l'équipe. Mais grâce à **la cohésion de l'équipe**, nous avons vite appris à l'utiliser et cette expérience nous a aidé à **avoir confiance dans l'apprentissage de nouvelles technologies.**<br><br>Cependant, certains services que l'on avait prévu d'intégrer ont dû être abandonnés par manque de temps. Par exemple, **la géolocalisation des utilisateurs** et la création de **l'espace Forum** n'ont pas pu être réalisés.<br><br>Enfin, **l'interdisciplinarité et le travail d'équipe** nous ont permis de créer un site fonctionnel et interactif qui comprend les fonctions essentielles.<br><br>




