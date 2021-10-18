
CREATE TABLE Membre
(
    idMembre INT PRIMARY KEY,
    DateNM DATE,
    RueM VARCHAR(100),
    CPM VARCHAR(255), 
    VillM VARCHAR(255),
    PaysM VARCHAR(255),
    EtatM VARCHAR(255),
    Numtel VARCHAR(5),
    Email VARCHAR(255),

    NomM VARCHAR(255),
    PrenomM VARCHAR(255),
    PasseWordM VARCHAR(255);

);

CREATE TABLE Frais
(
	IdFrais INT PRIMARY KEY,
	FraisInsertion INT, 
    FraisCommission INT
);


CREATE TABLE TypeOption 
(
	IdOption INT PRIMARY KEY,
	NomOptionCat VARCHAR(255),
	PrixCatalogue INT,
	PrixGold INT
);

CREATE TABLE TypeAvis 
(
	IdAvis INT PRIMARY KEY,
	TypeAvis VARCHAR(255)
);

CREATE TABLE Categorie
(	
	IdCodeCat INT PRIMARY KEY,
	LibCat VARCHAR(255)

);


CREATE TABLE SousCategorie
(
	IdSousCategorie INT PRIMARY KEY,
	LibSousCat VARCHAR(255),

	idCodeCat INT,
	FOREIGN Key (idCodeCat) REFERENCES Categorie(IdCodeCat)
);

CREATE TABLE Sous_souscategorie
(
	idSous_sous INT PRIMARY KEY,

	IdSousCategorie INT,
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
	idObjet INT PRIMARY KEY,

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
