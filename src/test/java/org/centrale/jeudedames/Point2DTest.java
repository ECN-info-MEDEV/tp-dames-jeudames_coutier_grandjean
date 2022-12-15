/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.jeudedames;

import static java.lang.Math.sqrt;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Manon Coutier
 */
public class Point2DTest {
    
    public Point2DTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of setPosition method, of class Point2D.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        int abs = 5;
        int ord = 7;
        Point2D instance = new Point2D();
        instance.setPosition(abs, ord);
        assertEquals(abs, instance.getX());
        assertEquals(ord, instance.getY());
    }

    /**
     * Test of translate method, of class Point2D.
     */
    @Test
    public void testTranslate() {
        System.out.println("translate");
        int dx = 2;
        int dy = -1;
        Point2D instance = new Point2D();
        int abs = instance.getX();
        int ord = instance.getY();
        instance.translate(dx, dy);
        assertEquals(abs+dx, instance.getX());
        assertEquals(ord+dy, instance.getY());
    }

    /**
     * Test of distance method, of class Point2D.
     */
    @Test
    public void testDistance() {
        System.out.println("distance");
        //p et instance sur une position différente (entier)
        Point2D p = new Point2D(0,5);
        Point2D instance = new Point2D();
        float expResult = 5;
        float result = instance.distance(p);
        assertEquals(expResult, result, 0);
        //p et instance sur la même position
        instance.setPosition(0, 5);
        expResult = 0;
        result = instance.distance(p);
        assertEquals(expResult, result, 0);
        
        
    }
    
}
