/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.jeudedames;

/**
 * Classe assurant la gestion des Joueurs
 * @author Manon Coutier
 */
public class Joueur {
    
    //ATTRIBUTS
    private String nom;
    private boolean couleur;
    
    //CONSTRUCTEURS
    public Joueur(String name,boolean col){
        this.nom = name;
        this.couleur = col;
    }
}
