/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.jeudedames;

/**
 * Classe assurant la gestion des positions 2D
 * @author Manon Coutier
 */
public class Point2D {
    //ATTRIBUTS
    /**
     * x : abscisse du point
     */
    private int x;
    /**
     * y : ordonnée du point
     */
    private int y;

    //CONSTRUCTEURS
    //Constructeur par défaut
    /**
     * Crée un point 2D par défaut.
     */
    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    //Constructeur de recopie
    /**
     * Crée un point 2D à partir d'un modèle.
     * @param p Point2D modèle
     */
    public Point2D(Point2D p) {
        this.x = p.x;
        this.y = p.y;
    }
    
    //Constructeur paramétré entièrement
    /**
     * Crée un point 2D entièrement paramétré.
     * @param x abscisse du point
     * @param y ordonnée du point
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }


    //SETTERS ET GETTERS
    //Getters
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //Setters
    
    public void setX(int abs) {
        x = abs;
    }

    public void setY(int ord) {
        y = ord;
    }

    
    //AUTRES MÉTHODES
    /**
     * Compare deux Point2D.
     * @param pos position comparée.
     * @return booléen vrai si les deux points sont à la même position.
     */
    public boolean equals(Point2D pos){
        if (pos == null){
            return false;
        }else{
            return ((x == pos.x) && (y == pos.y));
        }
    }
    
    /**
     * Affiche les coordonnées d'un point.
     */
    public void affiche() {
        System.out.print("[" + this.x + ";" + this.y + "]");
    }

    /**
     * Modifie les coordonnées d'un point.
     * @param abs nouvelle abscisse
     * @param ord nouvelle ordonnée
     */
    public void setPosition(int abs, int ord) {
        this.x = abs;
        this.y = ord;
    }

    /**
     * Translate un point.
     * @param dx translation horizontale
     * @param dy translation verticale
     */
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Calcule la distance entre le point considéré et un point p
     * @param p point
     * @return distance entre les deux points
     */
    public float distance(Point2D p) {
        int X = p.x-x;
        int Y = p.y-y;
        return (float) Math.hypot(X,Y);
    }
}
