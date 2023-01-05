/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.jeudedames;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Scanner;

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
        this.position = new Point2D(position);
    }
    
        
    //méthodes
    /**
     * vérifie qu'un pion peut être ou non promu et le promeut si c'est possible
     */
    public void promotion(){
        if (((this.couleur) && (this.getPosition().getY()==0)) || ((!this.couleur) && (this.getPosition().getY()==9))){
            this.setDame(true);
            System.out.print("Le pion en position ");
            this.getPosition().affiche();
            System.out.println(" est promu en dame.");
        }
    }

 /**
     * Méthode permettant de regarder si une case est occupée
     * @param pions : liste des pions du jeu
     * @param position : position de la case qu'on veut tester
     * @return true si la case est vide, sinon false
     */
    public boolean caseVide(ArrayList<Pion> pions, Point2D position){
        for (Pion p : pions){
            if (position.equals(p.position)){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Méthode permettant de savoir si une case est occupée par un pion adverse
     * @param pions : liste des pions du jeu
     * @param position : case testée
     * @return true s'il y a un ennemi, false sinon
     */
    public boolean caseEnnemi(ArrayList<Pion> pions, Point2D position){
        for (Pion p : pions){
            if (position.equals(p.position) && p.couleur != this.couleur){
                return true;
            }
        }
        return false;
    }
    
    /*
    private ArrayList<Point2D> deplaceManger (Partie jeu, Joueur joueur){
        ArrayList<Point2D> possibilites = new ArrayList<>();
        
        //on regarde toutes les positions possibles et on les stocke
        //on teste les quatre déplacements possibles en diagonales
        Point2D choix;
        for (int i=0; i<=1; i++){
            for (int j=0; j<=1; j++){
                choix=new Point2D(2*i + this.position.getX()-1, 2*j + this.position.getY()-1);
                
                // on regarde s'il y a un pion ennemi sur une diagonale
                // on doit vérifier que la case suivante en diagonale existe et qu'elle est vide
                if (caseEnnemi(jeu.listePion, choix, joueur.couleur)){
                    if (choix.getX()> 0 && choix.getX()<9 && choix.getY()>0 && choix.getY()<9){
                        Point2D  newpoint = new Point2D(abs(this.position.getX()- 2*choix.getX()), abs(this.position.getY()- 2*choix.getY()));
                        if (caseVide(jeu.listePion,newpoint)){
                            possibilites.add(choix);
                        }
                    }
                }
                
            }   
        }
        return possibilites;
    }
    */
    
    /*
    private void demandeManger(ArrayList<Point2D> possibilites, Scanner input){
        int i = 0;
        System.out.println("Vous pouvez encore manger des pions adverses, votre pion serait alors en :");
        for (Point2D p : possibilites){
            System.out.println(" - " + i + " ");
            p.affiche();
            System.out.println();
            i++;
        }
        int reponse = input.nextInt();
        input.nextLine();
    }
    */
    /**
     * Méthode permettant de manger un pion
     * @param nvcase : case sur laquelle sera le pion lorsque qu'il aura mangé
     * @param jeu : Partie concernée
     */
    public void manger(Point2D nvcase, Partie jeu){
        //suppression du pion ennemi
        Point2D manger = new Point2D(abs(this.position.getX()-nvcase.getX())/2, abs(this.position.getY()-nvcase.getY())/2);
        for (Pion p : jeu.getListePion()){
            if (manger.equals(p.position)){
                jeu.getListePion().remove(p);
            }
        }
        // deplacer le pion
        this.setPosition(nvcase);
    }
    
    /**
     * Méthode permettant de déplacer un pion selon les choix du joueur, elle mange si besoin les pions
     * @param jeu
     * @param joueur
     * @return true si on peut déplacer le pion, false sinon
     */
    public boolean deplace(Partie jeu, Joueur joueur){
        Scanner input = new Scanner(System.in);

        ArrayList<Point2D> deplacementsSimples = new ArrayList<>() ;
        ArrayList<Point2D> deplacementsManger = new ArrayList<>();
        
        //on regarde toutes les positions possibles et on les stocke
        //on teste les quatre déplacements possibles en diagonales
        Point2D choix;
        for (int i=0; i<=1; i++){
            for (int j=0; j<=1; j++){
                choix=new Point2D(2*i + this.position.getX()-1, 2*j + this.position.getY()-1);
                
                // test si la case est vide
                if (caseVide(jeu.getListePion(), choix)){
                    deplacementsSimples.add(choix);
                }
                
                // sinon s'il y a un pion ennemi
                // on doit vérifier que la case suivante en diagonale existe et qu'elle est vide
                else if (caseEnnemi(jeu.getListePion(), choix)){
                    if (choix.getX()> 0 && choix.getX()<9 && choix.getY()>0 && choix.getY()<9){
                        Point2D  newpoint = new Point2D(abs(this.position.getX()- 2*choix.getX()), abs(this.position.getY()- 2*choix.getY()));
                        if (caseVide(jeu.getListePion(),newpoint)){
                            deplacementsManger.add(newpoint);
                        }
                    }
                }
                
            }   
        }
        
        int i = 0;
        
        // vérifie qu'on peut déplacer ce pion
        if (deplacementsSimples.isEmpty() && deplacementsManger.isEmpty()){
            System.out.println("Vous ne pouvez pas déplacer ce pion");
            return false;
            
        } else if (! deplacementsManger.isEmpty()){
            System.out.println("Vous pouvez manger des pions adverses, votre pion serait alors en :");
            for (Point2D p : deplacementsManger){
                System.out.println(" - " + i + " ");
                p.affiche();
                System.out.println();
                i++;
            }
            
        } else {
            System.out.println("Vous ne pouvez pas manger avec ce pion");
            System.out.println("Vous pouvez faire des déplacements simples, votre pion serait alors en :");
            for (Point2D p : deplacementsSimples){
                System.out.println(" - " + i + " ");
                p.affiche();
                System.out.println();
                i++;
            }
        }
        
        int reponse = input.nextInt();
        input.nextLine();
        
        if (!deplacementsManger.isEmpty()){
           this.manger(deplacementsManger.get(reponse), jeu);
        }else{
            this.setPosition(deplacementsSimples.get(reponse));
        }
        
        return true; 
    }
    
}

