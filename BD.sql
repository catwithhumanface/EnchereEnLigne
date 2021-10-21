drop table if exists Enchere;
drop table if exists Choisir;
drop table if exists Commenter;
drop table if exists Statistique;
drop table if exists Objet;
drop table if exists Sous_souscategorie;
drop table if exists SousCategorie;
drop table if exists Categorie;
drop table if exists TypeAvis;
drop table if exists TypeOption;
drop table if exists Frais;
drop table if exists Membre ;
drop table if exists TypeMembre ;
drop table if exists FraisCommission;
drop table if exists FraisInsertion ;
drop table if exists Region;

CREATE TABLE Membre
(
    idMembre INT PRIMARY KEY AUTO_INCREMENT,
    PseudoMembre VARCHAR(255) UNIQUE,
    DateNM DATE,
    RueM VARCHAR(100),
    CPM VARCHAR(255), 
    VillM VARCHAR(255),
    PaysM VARCHAR(255),
    EtatM VARCHAR(255),
    Numtel VARCHAR(255),
    Email VARCHAR(255),
    NomM VARCHAR(255),
    PrenomM VARCHAR(255),
    PasseWordM VARCHAR(255) 
);




CREATE TABLE FraisInsertion
(
	FraisInsertion float PRIMARY KEY 
);

CREATE TABLE FraisCommission
(
    FraisCommission  float PRIMARY KEY
);



CREATE TABLE TypeOption 
(
	IdOption INT PRIMARY KEY AUTO_INCREMENT,
	NomOptionCat VARCHAR(255),
	PrixCatalogue INT,
	PrixGold INT
);

CREATE TABLE TypeAvis 
(
	IdAvis INT PRIMARY KEY AUTO_INCREMENT,
	TypeAvis VARCHAR(255)
);

CREATE TABLE Categorie
(	
	IdCodeCat INT PRIMARY KEY AUTO_INCREMENT,
	LibCat VARCHAR(255)

);






CREATE TABLE SousCategorie
(
	IdSousCategorie INT PRIMARY KEY AUTO_INCREMENT,
	LibSousCat VARCHAR(255),
        
	idCodeCat INT,
	FOREIGN Key (idCodeCat) REFERENCES Categorie(IdCodeCat)
);

CREATE TABLE Sous_souscategorie
(
	idSous_sous INT PRIMARY KEY AUTO_INCREMENT,
	IdSousCategorie INT,
        libSous_sous VARCHAR(255),
	FOREIGN Key(IdSousCategorie) references SousCategorie(IdSousCategorie)	
);

CREATE TABLE Objet 
(
	idObjet INT PRIMARY KEY AUTO_INCREMENT,
	TitreA VARCHAR(255),
	DescO VARCHAR(255),
	PrixDepart INT,
	PrixReserve INT,
	Prixachatimmediat INT,
	Regiondelivraison VARCHAR(255),
	Datedecloture DATETIME,
	EtatVente VARCHAR(255),
	PrixAchat INT,
    	FraisPort int,
	idMembre INT,
	IdCodeCat INT,
    IdSousCategorie INT,
    IdSous_sous INT,

    FOREIGN Key (idMembre) REFERENCES Membre(idMembre),
    FOREIGN KEY (IdCodeCat) REFERENCES Categorie (IdCodeCat),
    FOREIGN KEY (IdSousCategorie) REFERENCES SousCategorie (IdSousCategorie),
    FOREIGN KEY (IdSous_sous) REFERENCES Sous_souscategorie (IdSous_sous)

);



CREATE TABLE Statistique
(
	AnneeSemaine VARCHAR(255),
	CA_Total float,
	Vis_Total INT,
	NbObjet INT,
	
	
	PRIMARY KEY(AnneeSemaine)


);




CREATE TABLE Commenter (
	CommentairePerso VARCHAR(255),
	IdAvis INT,
	idMembre INT,
	FOREIGN KEY (IdAvis) REFERENCES TypeAvis (IdAvis),
	FOREIGN KEY (idMembre) REFERENCES Membre (idMembre),
	PRIMARY KEY (idmembre,IdAvis)

);

CREATE TABLE Choisir(

	IdOption INT,
	idObjet INT,

	FOREIGN KEY (IdOption) REFERENCES TypeOption (IdOption),
	FOREIGN KEY (idObjet) REFERENCES Objet  (idObjet),

	PRIMARY KEY (IdOption,idobjet)
);


CREATE TABLE Enchere (
	MontantPasE INT,
	MontantMaxE INT,
	dateheureEnchere DATETIME,

	idMembre INT,
	idObjet INT,

	FOREIGN KEY (idMembre) REFERENCES Membre (idMembre),
	FOREIGN KEY (idObjet) REFERENCES Objet  (idObjet),

	PRIMARY KEY (idmembre,idobjet,dateheureEnchere)
);

CREATE TABLE TypeMembre
(
    idTypeMembre INT PRIMARY KEY,
    nomTypeMembre VARCHAR(255)

);

ALTER TABLE Membre
ADD idTypeMembre INT,
ADD CONSTRAINT idTypeMembre FOREIGN KEY(idTypeMembre) REFERENCES TypeMembre(idTypeMembre);

Insert into TypeMembre (idTypeMembre, nomTypeMembre) VALUES (1, 'Client');
Insert into TypeMembre (idTypeMembre, nomTypeMembre) VALUES (2, 'Service Informatique');
Insert into TypeMembre (idTypeMembre, nomTypeMembre) VALUES (3, 'Service Commercial');
Insert into TypeMembre (idTypeMembre, nomTypeMembre) VALUES (4, 'Service Juridique');





insert into Membre
(
    PseudoMembre,
    DateNM,
    RueM,
    CPM, 
    VillM,
    PaysM,
    EtatM,
    Numtel,
    Email,
    NomM,
    PrenomM,
    PasseWordM,
    idTypeMembre

)
values("joohyunAnn",
    DATE(NOW()),
    "rue",
    "31000", 
    "Toulouse",
    "France",
    "Membre",
    "06060606",
    "a@a.com",
    "Ann",
    "Joohyun",
    "aaa",
    1
);
INSERT INTO Categorie (LibCat) VALUES ( 'Multimédia');
INSERT INTO Categorie (LibCat) VALUES ( 'Electroménager');
INSERT INTO Categorie (LibCat) VALUES ( 'Mobilier');


insert into SousCategorie (LibSousCat,idCodeCat) VALUES ( 'Télévision', 1);
insert into SousCategorie (LibSousCat,idCodeCat) VALUES ( 'Vidéo', 1);
insert into SousCategorie (LibSousCat,idCodeCat) VALUES ( 'Lavage', 2);
insert into SousCategorie (LibSousCat,idCodeCat) VALUES ( 'Froid', 2);

insert into Sous_souscategorie (IdSousCategorie,libSous_sous) VALUES (1, 'Téléviseur4/3');
INSERT INTO FraisInsertion values(0.1);
INSERT INTO FraisInsertion values(0.2);
INSERT INTO FraisInsertion values(0.4);
INSERT INTO FraisInsertion values(1.0);

INSERT INTO FraisCommission values(0.05);
INSERT INTO FraisCommission values(0.03);
INSERT INTO FraisCommission values(0.015);






insert into Sous_souscategorie (IdSousCategorie,libSous_sous) VALUES (1, 'Téléviseur16/9');
insert into Sous_souscategorie (IdSousCategorie,libSous_sous) VALUES (3, 'Lave linge');
insert into Sous_souscategorie (IdSousCategorie,libSous_sous) VALUES (3, 'Sèche linge');

Create Table Region ( 
    regionL VARCHAR(256),
	PRIMARY KEY (regionL)
);

insert into Region (regionL) VALUES ( "Chine");
insert into Region (regionL) VALUES ( 'Corée');
insert into Region (regionL) VALUES ( 'nicaragua');
insert into Region (regionL) VALUES ( "Côte d'Ivoire");

insert into Objet (TitreA, DescO, PrixDepart, PrixReserve, Prixachatimmediat, Regiondelivraison, EtatVente, PrixAchat, FraisPort, idMembre, IdCodeCat, IdSousCategorie, IdSous_sous) values("titre", "desc", 100, 100, 300, "toulouse", "en cours", 0, 0, 1, 1, 1,1);

insert into Objet (TitreA, DescO, PrixDepart, PrixReserve, Prixachatimmediat, Regiondelivraison, EtatVente, PrixAchat, FraisPort, idMembre, IdCodeCat, IdSousCategorie, IdSous_sous) values("titre1", "desc", 100, 100, 300, "toulouse", "en cours", 0, 0, 1, 1, 1,1);






insert into Enchere values(200, 400, TIMESTAMP(NOW()), 1, 1);



insert into Objet (TitreA, DescO, PrixDepart, PrixReserve, Prixachatimmediat, Regiondelivraison, EtatVente, PrixAchat, FraisPort, idMembre, IdCodeCat, IdSousCategorie, IdSous_sous, Datedecloture) values("titre1", "desc", 100, 100, 300, "toulouse", "en cours", 0, 0, 1, 1, 1,1, TIMESTAMP(now()));
INSERT INTO objet values(
'7', 'Camion', 'desc', '100', '100', '300', 'toulouse', '2020-11-09', 'en cours', '50', '50', '1', '3', '1', '1');

