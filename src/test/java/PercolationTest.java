
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ravigu
 */
public class PercolationTest {
    
    @Test
    public void testTwentyMetric()
    {
        int size = 10000;
        
        long starttm, endtm;
        starttm = System.currentTimeMillis();
        Percolation percolation = new Percolation(size);
        Random randomizedRows = new Random();
        Random randomizedCols = new Random();
        while(!percolation.percolates()){
            int i = randomizedRows.nextInt(size+1);
            int j = randomizedCols.nextInt(size+1);
            if(i==0 || j==0)
                continue;
            //System.out.println("Punching ("+i+","+j+")");
            try {
                percolation.open(i, j);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(PercolationTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        endtm = System.currentTimeMillis();
        System.out.println("total time in miliseconds " + (endtm-starttm));
        //percolation.printConnectedComponents();
    }
    
}
