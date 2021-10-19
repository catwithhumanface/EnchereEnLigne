drop table Enchere;
drop table Choisir;
drop table Commenter;
drop table Statistique;
drop table Objet;
drop table Contenir_Cate;
drop table Sous_souscategorie;
drop table SousCategorie;
drop table Categorie;
drop table TypeAvis;
drop table TypeOption;
drop table Frais;
drop table Membre;
drop table TypeMembre;



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

CREATE TABLE Frais
(
	IdFrais INT PRIMARY KEY AUTO_INCREMENT,
	FraisInsertion INT, 
    FraisCommission INT
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

CREATE TABLE Contenir_Cate
(

	idSous_sous INT,
	IdSousCategorie INT,

	FOREIGN KEY(idSous_sous) REFERENCES Sous_souscategorie(idSous_sous),
	FOREIGN KEY(IdSousCategorie) REFERENCES SousCategorie(IdSousCategorie),

	PRIMARY KEY(IdSousCategorie,idSous_sous)
);


CREATE TABLE Objet 
(
	idObjet INT PRIMARY KEY AUTO_INCREMENT,
	NumO VARCHAR(255),
	TitreA VARCHAR(255),
	DescO VARCHAR(255),
	PrixDepart INT,
	PrixReserve INT,
	Prixachatimmédiat INT,
	Régiondelivraison VARCHAR(255),
	Datedecloture DATE,
	EtatVente VARCHAR(255),
	PrixAchat VARCHAR(255),
	idMembre INT,
	IdFrais INT,
	IdCodeCat INT,

    FOREIGN Key (idMembre) REFERENCES Membre(idMembre),
    FOREIGN Key (IdFrais) REFERENCES Frais(IdFrais),
    FOREIGN KEY (IdCodeCat) REFERENCES Categorie (IdCodeCat)

);


CREATE TABLE Statistique
(
	AnneeSemaine VARCHAR(255),
	CA_Total INT,
	Vis_Total INT,
	NbObjet INT,
	
    IdCodeCat INT,
	FOREIGN KEY (IdCodeCat) REFERENCES Categorie (IdCodeCat),
	
	PRIMARY KEY(AnneeSemaine,IdCodeCat)


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
	dateheureEnchere Date,

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





ALTER TABLE Membre AUTO_INCREMENT=0;
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
    "Normal",
    "06060606",
    "a@a.com",
    "Ann",
    "Joohyun",
    "aaa",
    1
);
