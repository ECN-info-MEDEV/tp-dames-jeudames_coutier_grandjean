/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.jeudedames;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Manon Coutier
 */
public class PionTest {
    
    public PionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    /**
     * Test of promotion method, of class Pion.
     */
    @Test
    public void testPromotion() {
        System.out.println("promotion");
        int i;
        int j;
        Pion blanc = new Pion(true);
        Pion noir = new Pion(false);
        //Test promotion vraie
        blanc.getPosition().setY(0);
        noir.getPosition().setY(9);
        
        for (i=0;i<10;i++){
            //remise à l'état de pion
            blanc.setDame(false);
            noir.setDame(false);
            //déplacement
            blanc.getPosition().setX(i);
            noir.getPosition().setX(i);
            //test de promotion
            blanc.promotion();
            noir.promotion();
            //test
            assertTrue(blanc.isDame());
            assertTrue(noir.isDame());
        }
        //Test promotion fausse blanc
        for (i=0;i<10;i++){
            for (j=1;j<10;j++){
                //remise à l'état de pion
                blanc.setDame(false);
                //déplacement
                blanc.getPosition().setPosition(i, j);
                //test de promotion
                blanc.promotion();
                //test
                assertFalse(blanc.isDame());
            }
        }
        //Test promotion fausse noir
        for (i=0;i<10;i++){
            for (j=0;j<9;j++){
                //remise à l'état de pion
                noir.setDame(false);
                //déplacement
                noir.getPosition().setPosition(i, j);
                //test de promotion
                noir.promotion();
                //test
                assertFalse(noir.isDame());
            }
        }
        
    }
    
}
