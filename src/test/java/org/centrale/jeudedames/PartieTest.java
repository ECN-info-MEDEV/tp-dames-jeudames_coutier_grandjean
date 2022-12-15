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
     * Test of init method, of class Partie.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        Partie instance = new Partie();
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quelPion method, of class Partie.
     */
    @Test
    public void testQuelPion() {
        System.out.println("quelPion");
        Partie instance = new Partie();
        Pion pion = new Pion(true,new Point2D(),false);
        assertEquals("○", instance.quelPion(pion));
        pion.setDame(true);
        assertEquals("☺", instance.quelPion(pion));
        pion.setCouleur(false);
        assertEquals("☻", instance.quelPion(pion));
        pion.setDame(false);
        assertEquals("◙", instance.quelPion(pion));
        
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
        boolean expResult = false;
        boolean result = instance.pionSurCase(i, j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of affichePlateau method, of class Partie.
     */
    @Test
    public void testAffichePlateau() {
        System.out.println("affichePlateau");
        Partie instance = new Partie();
        instance.affichePlateau();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
