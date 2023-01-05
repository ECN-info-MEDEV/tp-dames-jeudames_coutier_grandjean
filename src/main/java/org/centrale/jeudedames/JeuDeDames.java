/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.centrale.jeudedames;

/**
 *
 * @author Manon Coutier
 */
public class JeuDeDames {

    public static void main(String[] args) {
        Partie partie = new Partie();
        partie.init();
        partie.affichePlateau();
    }
}
