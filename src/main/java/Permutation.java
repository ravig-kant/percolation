
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ravigu
 */
public class Permutation {
    public static void main(String[] args){
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        while(!StdIn.isEmpty()){
            String input = StdIn.readString();
            queue.enqueue(input);
        }
        
        while(k-- > 0){
            String out = queue.dequeue();
            StdOut.println(out);
        }
    }
}
