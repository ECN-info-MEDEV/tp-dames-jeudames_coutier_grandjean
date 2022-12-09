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
    public ArrayList<Pion> listePion;
    private int tour;
    
    public Partie(){
        listePion = new ArrayList<>();
        for (int i=0;i<10;i++){
            listePion.add(new Pion());
        }
        for (int i=0;i<10;i++){
            listePion.add(new Pion());
        }
    }
        
    
    public affichePlateau(){
        
        
        System.out.println("○◙");
    }
    
}
