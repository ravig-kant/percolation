/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ravigu
 */
public class TestPoint {
    
    public TestPoint() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         Point p = new Point(355, 7);
         Point q = new Point(454, 465);
         Point r = new Point(54, 465);
         
         System.out.println("p.compareTo(q)  =" + p.compareTo(q));
         System.out.println("q.compareTo(r)  =" + q.compareTo(r));
         System.out.println("p.compareTo(r)  =" + p.compareTo(r));
     }
}
