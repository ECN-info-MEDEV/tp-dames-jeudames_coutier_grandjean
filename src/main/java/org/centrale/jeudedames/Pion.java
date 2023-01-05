/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.jeudedames;

import java.util.ArrayList;

/**
 *
 * @author Laure
 */
public class Pion {
    
    // attributs
    private boolean dame;
    private boolean couleur; // true = blanc et false = noir
    private Point2D position;
    
    // Constructeur
    
    /**
     * Constructeur d'un Pion à partir de sa couleur et de sa position
     * @param couleur = couleur du pion (true = blanc et false = noir)
     * @param position = position du pion (en haut à gauche c'est (0;0) donc sa position
     * est dans [0;9]**2)
     */
    public Pion(boolean couleur, Point2D position){
        this.couleur = couleur;
        this.position = position;
        this.dame = false;
    }
    
    /**
     * Constructeur d'un Pion à partir de sa couleur
     * @param couleur = couleur du pion (true = blanc et false = noir)
     */
    public Pion(boolean couleur){
        this.couleur = couleur;
        this.dame = false;
        this.position = new Point2D();
    }
    
    /**
     * Constructeur d'un Pion à partir de sa couleur, de sa position et du fait de si c'est une dame ou pas
     * @param couleur = couleur du pion (true = blanc et false = noir)
     * @param position = position du pion (en haut à gauche c'est (0;0) donc sa position
     * est dans [0;9]**2)
     * @param dame = booléen true si c'est une dame, false sinon
     */
    public Pion(boolean couleur, Point2D position, boolean dame){
        this.couleur = couleur;
        this.position = position;
        this.dame = dame;
    }
    
    //Setters et Getters 

    public boolean isDame() {
        return dame;
    }

    public void setDame(boolean dame) {
        this.dame = dame;
    }

    public boolean isCouleur() {
        return couleur;
    }

    public void setCouleur(boolean couleur) {
        this.couleur = couleur;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }
    
        
    //méthodes
    /**
     * vérifie qu'un pion peut être ou non promu et le promeut si c'est possible
     */
    public void promotion(){
        if (((this.couleur) && (this.getPosition().getY()==0)) || ((this.couleur) && (this.getPosition().getY()==9))){
            this.setDame(true);
            System.out.print("Le pion en position ");
            this.getPosition().affiche();
            System.out.println(" est promu en dame.");
        }
    }
    
    /**
     * Méthode permettant de déplacer un pion.
     * S'il existe un déplacement permettant de manger des pions, alors on est obligé de 
     * manger des pions. On choisit alors le déplacement permettant de manger le plus de 
     * pions (en nombre et pas en valeur (dame ou pas)).
     * Sinon, le joueur peut choisir son déplacement parmi tous ceux qui sont possibles
     */
    public void deplace(){
        ArrayList<Point2D> listeDeplacement = new ArrayList<>() ;
        
        //on regarde toutes les positions possibles et on les stocke
        //on teste les quatre déplacements possibles en diagonales
        Point2D choix;
        for (int i=0; i<=1; i++){
            for (int j=0; j<=1; j++){
                choix=new Point2D(2*i + this.position.getX()-1, 2*j + this.position.getY()-1);
                listeDeplacement.add(choix);
            }   
        }
        /*
        for (Pion pion : listePion){
            if 
        }
        */
        
    }
    
    /**
     * 
     * @param place
     * @param listeCapturePossible
     * @param listecapture
     * @return 
     */
    public ArrayList<ArrayList<Point2D>> capture(Point2D place, ArrayList<Point2D> listeCapturePossible, ArrayList<Point2D> listecapture){
        
        if (!listeCapturePossible.isEmpty()){
            for (Point2D possibilite : listeCapturePossible){
                int x = 2*place.getX()-possibilite.getX();
                int y = 2*place.getY()-possibilite.getY();
                Point2D nvPosition = new Point2D(x,y);
            }
        }
        ArrayList<ArrayList<Point2D>> nvListeCapture = new ArrayList<ArrayList<Point2D>>() ;
        return nvListeCapture;
    }
}
