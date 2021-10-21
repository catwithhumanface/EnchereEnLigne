/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enchere.model;

/**
 *
 * @author joohyunann
 */
public class MembreSQL {
    final static String SIGN_IN = "Select * from Membre where idTypeMembre=? and PseudoMembre=? and PasseWordM=?";
    final static String SIGN_UP = "insert into Membre (PseudoMembre, DateNM, RueM, CPM, VillM, PaysM, Numtel, Email,"
            + " NomM, PrenomM, PasseWordM, idTypeMembre) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1)";
    final static String CHECKPSEUDO = "Select * from Membre where PseudoMembre=?";
    final static String GETMESVENTES = "Select * from Objet where idMembre=?";
    final static String GETMESENCHERES = "Select * from Enchere where idMembre=?";
}
