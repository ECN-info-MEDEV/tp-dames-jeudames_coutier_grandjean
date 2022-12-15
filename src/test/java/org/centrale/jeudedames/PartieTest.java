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
 * @author bryan
 */
public class PartieTest {
    
    public PartieTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of quelPion method, of class Partie.
     */
    @Test
    public void testQuelPion() {
        System.out.println("quelPion");
        Partie instance = new Partie();
        Pion pion = new Pion(true,new Point2D(),false);
        assertEquals("b", instance.quelPion(pion));
        pion.setDame(true);
        assertEquals("B", instance.quelPion(pion));
        pion.setCouleur(false);
        assertEquals("N", instance.quelPion(pion));
        pion.setDame(false);
        assertEquals("n", instance.quelPion(pion));
        
    }

    /**
     * Test of pionSurCase method, of class Partie.
     */
    @Test
    public void testPionSurCase() {
        System.out.println("pionSurCase");
        int i = 0;
        int j = 0;
        Partie instance = new Partie();
        instance.addListePion(new Pion(true, new Point2D(i,j)));
        assertEquals(true, instance.pionSurCase(i, j));
        assertEquals(false, instance.pionSurCase(i+1, j+2));
    }


    
}
