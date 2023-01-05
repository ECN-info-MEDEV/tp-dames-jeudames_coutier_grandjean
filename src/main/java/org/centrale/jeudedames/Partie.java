/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.jeudedames;

import java.util.ArrayList;

/**
 *
 * @author bryan
 */
public class Partie {
    
    //Attributs
    private ArrayList<Pion> listePion;
    private int tour;

    //Getters et Setters
    public ArrayList<Pion> getListePion() {
        return listePion;
    }

    public int getTour() {
        return tour;
    }

    public void setListePion(ArrayList<Pion> listePion) {
        this.listePion = listePion;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }
    
    public void addListePion(Pion pion){
        this.listePion.add(pion);
    }
    
    //Constructeur
    public Partie(){
        tour = 0;
        listePion = new ArrayList<>();
    }
    
    /**
     * Initialisation du plateau en y plaçant les pions
     */
    public void init(){
        int x;
        int y;
        for (int i=0;i<4;i++){
            for (int j=0;j<5;j++){
                y = i;
                x = j*2+((i+1)%2);
                listePion.add(new Pion(false, new Point2D(x,y)));
            }
            
        }
        for (int i=0;i<4;i++){
            for (int j=0;j<5;j++){
                y = 9-i;
                x = j*2+(i%2);
                listePion.add(new Pion(true, new Point2D(x,y)));
            }
        }
    }
    
    /**
     * Renvoie la représentation du pion
     * Blanc : pion = b ; dame = B
     * Noir  : pion = n ; dame = N
     * @param pion
     * @return 
     */
    public String quelPion(Pion pion){
        if ( pion.isCouleur() ) { 
        //Blanc
            if ( pion.isDame() ){ 
            //Dame
                return "B";
            }else{ 
            //Pion
                return "b";
            }
        }else{ 
        //Noir
            if ( pion.isDame() ){ 
            //Dame
                return "N";
            }else{ 
            //Pion
                return "n";
            }
        }
    }
    
    /**
     * Renvoie true si un pion/Dame se trouve sur la case et l'affiche, sinon renvoie false
     * @param i
     * @param j
     * @return
     */
    public boolean pionSurCase(int i, int j){
        String affPion;
        for (Pion pion : listePion){
            if ( pion.getPosition().equals(new Point2D(i,j)) ){
                affPion = quelPion(pion);
                System.out.print(affPion);
                return true;
            }
        }
        //Si aucun pion se trouve sur la case
        return false;
    }
    
    /**
     * Affiche le plateau de taille 10x10
     * Blanc : pion = b ; dame = B
     * Noir  : pion = n ; dame = N
     * Case vide = •
     */
    public void affichePlateau(){
        //Plateau de 10x10
        for (int i = 0 ; i<10 ; i++){
            for (int j = 0 ; j<10 ; j++){
                if ( (i+j)%2 == 0){ 
                //Les pions ne sont que sur les cases noires
                    System.out.print("+");
                }else{
                    if (!pionSurCase(j,i)){
                        System.out.print("-");
                    }
                }
                System.out.print(" ");
            }
            //Changement de ligne
            System.out.println("");
        }
    }
    
}
