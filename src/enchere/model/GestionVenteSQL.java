/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enchere.model;

/**
 *
 * @author Tong
 */

// Tous les requetes SQL
public class GestionVenteSQL {
    final static String GETIDCATE ="Select IdCodeCat from  Categorie C where C.LibCat = ?";
            
    final static String GETIDCATESous="Select IdSousCategorie from  souscategorie SC where SC.LibSousCat =?";
   
    final static String GETIDCATESous_sous= "Select idSous_sous from sous_souscategorie ssc where ssc.libSous_sous = ?"; 
   
    final static String GETSOUSCAT = "Select LibSousCat from SousCategorie SC, Categorie C where SC.idCodeCat = C.IdCodeCat and C.LibCat =?";   
    final static String GETSOUS_SOUS = "Select LibSous_sous from SousCategorie SC, Sous_souscategorie ssC where SC.IdSousCategorie = ssc.IdSousCategorie and SC.LibSousCat =?";  
   
    final static String REGION ="select regionL from Region";
    final static String MISENVENTE = "insert into Objet(TitreA,DescO,PrixDepart,PrixReserve,"+ 
           "Prixachatimmediat,Regiondelivraison,Datedecloture,EtatVente,PrixAchat,idMembre,FraisPort,IdCodeCat,IdSousCategorie,IdSous_sous)"+
           "values(?,?,?,?,?,?,?,'En Vente',0,1,?,?,?,?)";
   
    final static String GetCATE = "select LibCat from Categorie";
    final static String GetSOUSSOUS = "select LibSous_sous from Sous_souscategorie";
    final static String GETLESOBJETS = "select * from Objet";
    final static String GETENCHERES = "select * from Enchere where idObjet = ?";
    final static String GETENCHERISSEUR = "select * from Membre where idMembre = ?";
  }   
  
