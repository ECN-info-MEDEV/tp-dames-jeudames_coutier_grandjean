/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.jeudedames;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe assurant la gestion des Joueurs
 * @author Manon Coutier
 */
public class Joueur {
    
    //ATTRIBUTS
    private String nom;
    private boolean couleur;
    
    //CONSTRUCTEURS
    /**
     * Constructeur paramétré
     * @param name nom du joueur
     * @param col couleur du joueur (true pour blanc, false pour noir)
     */
    public Joueur(String name,boolean col){
        this.nom = name;
        this.couleur = col;
        
    }
    
    //GETTERS ET SETTERS

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isCouleur() {
        return couleur;
    }

    public void setCouleur(boolean couleur) {
        this.couleur = couleur;
    }
    
    //AUTRES METHODES
    /**
     * Affiche la liste des pions du joueur
     * @param partie 
     */
    public void afficheListePion(Partie partie){
        int i = 0; //compteur de pion
        for (Pion p : partie.getListePion()){
            if (p.isCouleur()== this.isCouleur()){
                System.out.println(i+" - Le pion en ");
                p.getPosition().affiche();
                System.out.println();
                i++;
            }
        }
    }
    /**
     * Demande à un joueur le pion qu'il veut déplacer et le déplace
     * @param scan
     * @param partie 
     */
    public void jouer(Scanner scan, Partie partie){
        boolean valide = false;
        
        int choix;
        
        System.out.println("C'est au tour de "+ this.nom + ".");
        System.out.println("Quel pion veux-tu déplacer ? Choisit le numéro correspondant.");
        this.afficheListePion(partie);
        
        while (!valide){
            try{
                choix = scan.nextInt();
                if (choix >= partie.getListePion().size() || choix < 0){
                    System.out.println("Oups, cela ne correspond à aucun pion ! Réessaie");
                }else{
                    /**if (partie.getListePion().get(choix).deplace(partie, this)){
                       valide = true; 
                    }**/
                }
            }catch (InputMismatchException ex){
                System.out.println("Oups, cela ne correspond à aucun pion ! Réessaie");        
            }
        }
    }
}
