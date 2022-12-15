/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.jeudedames;

/**
 *
 * @author Laure
 */
public class Pion {
    
    // attributs
    private boolean dame;
    private boolean couleur; // true = blanc et false = noir
    private Point2D position;
    
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
        if (((this.couleur==true) && (this.getPosition().getY()==0)) || ((this.couleur==false) && (this.getPosition().getY()==9))){
            this.setDame(true);
            System.out.println("Le pion en position ");
            this.getPosition().affiche();
            System.out.println(" est promu en dame.");
        }
    }
}
