/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.centrale.jeudedames;

import java.util.Scanner;

/**
 *
 * @author Manon Coutier
 */
public class JeuDeDames {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Partie partie = new Partie();
        partie.init();
        partie.affichePlateau();
        Joueur joueur1 = new Joueur("joueurBlanc", true);
        Joueur joueur2 = new Joueur("joueurNoir", false);
        
        while (!partie.finPartie()){
            joueur1.jouer(scan, partie);
            partie.affichePlateau();
            if (!partie.finPartie()){
                joueur2.jouer(scan, partie);
                partie.affichePlateau();
            }
        }
    }
}
