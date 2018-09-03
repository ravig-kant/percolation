
import edu.princeton.cs.algs4.Stopwatch;
import org.junit.Assert;
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
public class TestRandomizedQueue {

    @Test
    public void testEnqueue() {
        {
            RandomizedQueue<Integer> queue = new RandomizedQueue<>();
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 1000000; i++) {
                queue.enqueue(i);
            }
            System.out.printf(" Time taken to enqueue 1 million %f\n", stopwatch.elapsedTime());
            System.out.println(" Size of the queue is " + queue.size());
        }

        {
            RandomizedQueue<Integer> queue = new RandomizedQueue<>();
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 2000000; i++) {
                queue.enqueue(i);
            }
            System.out.println(" Time taken to enqueue 2 million " + stopwatch.elapsedTime());
            System.out.println(" Size of the queue is " + queue.size());
        }

        {
            RandomizedQueue<Integer> queue = new RandomizedQueue<>();
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 4000000; i++) {
                queue.enqueue(i);
            }
            System.out.println(" Time taken to enqueue 4 million " + stopwatch.elapsedTime());
            System.out.println(" Size of the queue is " + queue.size());
        }

        {
            RandomizedQueue<Integer> queue = new RandomizedQueue<>();
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 8000000; i++) {
                queue.enqueue(i);
            }
            System.out.println(" Time taken to enqueue 8 million " + stopwatch.elapsedTime());
            System.out.println(" Size of the queue is " + queue.size());
        }

        {
            RandomizedQueue<Integer> queue = new RandomizedQueue<>();
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 16000000; i++) {
                queue.enqueue(i);
            }
            System.out.println(" Time taken to enqueue 16 million " + stopwatch.elapsedTime());
            System.out.println(" Size of the queue is " + queue.size());
        }
    }

    @Test
    public void testDequeue() {
        {
            RandomizedQueue<Integer> queue = new RandomizedQueue<>();

            for (int i = 0; i < 1000000; i++) {
                queue.enqueue(i);
            }
            System.out.println(" Size of the queue before dequeuing is " + queue.size());

            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 1000000; i++) {
                queue.dequeue();
            }
            System.out.printf(" Time taken to enqueue 1 million %f\n", stopwatch.elapsedTime());
            System.out.println(" Size of the queue after dequeue is " + queue.size());
        }

        {
            RandomizedQueue<Integer> queue = new RandomizedQueue<>();

            for (int i = 0; i < 2000000; i++) {
                queue.enqueue(i);
            }
            System.out.println(" Size of the queue before dequeuing is " + queue.size());

            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 2000000; i++) {
                queue.dequeue();
            }
            System.out.printf(" Time taken to enqueue 2 million %f\n", stopwatch.elapsedTime());
            System.out.println(" Size of the queue after dequeue is " + queue.size());
        }

        {
            RandomizedQueue<Integer> queue = new RandomizedQueue<>();

            for (int i = 0; i < 4000000; i++) {
                queue.enqueue(i);
            }
            System.out.println(" Size of the queue before dequeuing is " + queue.size());

            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 4000000; i++) {
                queue.dequeue();
            }
            System.out.printf(" Time taken to enqueue 4 million %f\n", stopwatch.elapsedTime());
            System.out.println(" Size of the queue after dequeue is " + queue.size());
        }

        {
            RandomizedQueue<Integer> queue = new RandomizedQueue<>();

            for (int i = 0; i < 8000000; i++) {
                queue.enqueue(i);
            }
            System.out.println(" Size of the queue before dequeuing is " + queue.size());

            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 8000000; i++) {
                queue.dequeue();
            }
            System.out.printf(" Time taken to enqueue 8 million %f\n", stopwatch.elapsedTime());
            System.out.println(" Size of the queue after dequeue is " + queue.size());
        }

        {
            RandomizedQueue<Integer> queue = new RandomizedQueue<>();

            for (int i = 0; i < 16000000; i++) {
                queue.enqueue(i);
            }
            System.out.println(" Size of the queue before dequeuing is " + queue.size());

            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 16000000; i++) {
                queue.dequeue();
            }
            System.out.printf(" Time taken to enqueue 16 million %f\n", stopwatch.elapsedTime());
            System.out.println(" Size of the queue after dequeue is " + queue.size());
        }
    }

    @Test
    public void testIterator() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        int[] numsDequeued = new int[100000];
        for (int i = 0; i < 100000; i++) {
            queue.enqueue(i);
        }
        System.out.println(" Size of queue before iterating " + queue.size());
       
        for (Integer itr : queue) {
            Assert.assertFalse( numsDequeued[itr]==1);
            numsDequeued[itr] = 1;         
        }

        System.out.println(" Size of queue after iterating " + queue.size());
    }

}
