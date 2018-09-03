
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;
import java.lang.instrument.Instrumentation;
import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.BeforeClass;
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
public class DequeTest {

    private static Integer[] nums = new Integer[4000];

    @BeforeClass
    public static void setUp() {
        In in = new In("C:\\Users\\ravigu\\Coursera\\Algorithms\\Assignments\\QuickUnion\\Test\\percolation\\wayne98.txt");
        for (int i = 0; i < 4000; i++) {
            nums[i] = in.readInt();
        }
    }

    @Test
    public void testAddFirst() {

        {
            Deque<Integer> testDeck = new Deque<>();
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 1000; i++) {
                testDeck.addFirst(i);
            }

            System.out.println(" 1000 addFirst takes time " + stopwatch.elapsedTime());
            System.out.println(" Size of deck " + testDeck.size());
            //System.out.println(" Size of deck for 1000 elements is " + ObjectSizeFetcher.getObjectSize(testDeck));
        }

        {
            Deque<Integer> testDeck = new Deque<>();
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 2000; i++) {
                testDeck.addFirst(i);
            }

            System.out.println(" 2000 addFirst takes time " + stopwatch.elapsedTime());
            System.out.println(" Size of deck " + testDeck.size());
            //System.out.println(" Size of deck for 2000 elements is " + ObjectSizeFetcher.getObjectSize(testDeck));
        }

        {
            Deque<Integer> testDeck = new Deque<>();
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 4000; i++) {
                testDeck.addFirst(i);
            }

            System.out.println(" 4000 addFirst takes time " + stopwatch.elapsedTime());
            System.out.println(" Size of deck " + testDeck.size());
            //System.out.println(" Size of deck for 4000 elements is " + ObjectSizeFetcher.getObjectSize(testDeck));
        }

        {
            Deque<Integer> testDeck = new Deque<>();
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 100000; i++) {
                testDeck.addFirst(i);
            }

            System.out.println(" 100,000 addFirst takes time " + stopwatch.elapsedTime());
            System.out.println(" Size of deck " + testDeck.size());
            //System.out.println(" Size of deck for 100,000 elements is " + ObjectSizeFetcher.getObjectSize(testDeck));
        }

    }

    @Test
    public void testRemoveFirst() {

        {
            Deque<Integer> testDeck = new Deque<>();

            for (int i = 0; i < 1000; i++) {
                testDeck.addFirst(i);
            }

            System.out.println(" Size of deck before 1000 removeFirst is " + testDeck.size());
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 1000; i > 0;) {
                Assert.assertEquals((long) testDeck.removeFirst(), --i);
            }

            System.out.println(" 1000 removeFirst takes time " + stopwatch.elapsedTime());
            System.out.println(" Size of deck after 1000 removeFirst is " + testDeck.size());
        }

        {
            Deque<Integer> testDeck = new Deque<>();

            for (int i = 0; i < 2000; i++) {
                testDeck.addFirst(i);
            }

            System.out.println(" Size of deck before 2000 removeFirst is " + testDeck.size());
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 2000; i > 0;) {
                Assert.assertEquals((long) testDeck.removeFirst(), --i);
            }

            System.out.println(" 2000 removeFirst takes time " + stopwatch.elapsedTime());
            System.out.println(" Size of deck after 2000 removeFirst is " + testDeck.size());
        }

        {
            Deque<Integer> testDeck = new Deque<>();

            for (int i = 0; i < 4000; i++) {
                testDeck.addFirst(i);
            }

            System.out.println(" Size of deck before 4000 removeFirst is " + testDeck.size());
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 4000; i > 0;) {
                Assert.assertEquals((long) testDeck.removeFirst(), --i);
            }

            System.out.println(" 4000 removeFirst takes time " + stopwatch.elapsedTime());
            System.out.println(" Size of deck after 4000 removeFirst is " + testDeck.size());
        }

        {
            Deque<Integer> testDeck = new Deque<>();

            for (int i = 0; i < 100000; i++) {
                testDeck.addFirst(i);
            }

            System.out.println(" Size of deck before 100000 removeFirst is " + testDeck.size());
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 100000; i > 0;) {
                Assert.assertEquals((long) testDeck.removeFirst(), --i);
            }

            System.out.println(" 100000 removeFirst takes time " + stopwatch.elapsedTime());
            System.out.println(" Size of deck after 100000 removeFirst is " + testDeck.size());
        }

    }

    @Test
    public void testAddLast() {

        {
            Deque<Integer> testDeck = new Deque<>();
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 1000; i++) {
                testDeck.addLast(i);
            }

            System.out.println(" 1000 addLast takes time " + stopwatch.elapsedTime());
            System.out.println(" Size of deck " + testDeck.size());
            //System.out.println(" Size of deck for 1000 elements is " + ObjectSizeFetcher.getObjectSize(testDeck));
        }

        {
            Deque<Integer> testDeck = new Deque<>();
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 2000; i++) {
                testDeck.addLast(i);
            }

            System.out.println(" 2000 addLast takes time " + stopwatch.elapsedTime());
            System.out.println(" Size of deck " + testDeck.size());
            //System.out.println(" Size of deck for 2000 elements is " + ObjectSizeFetcher.getObjectSize(testDeck));
        }

        {
            Deque<Integer> testDeck = new Deque<>();
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 4000; i++) {
                testDeck.addLast(i);
            }

            System.out.println(" 4000 addLast takes time " + stopwatch.elapsedTime());
            System.out.println(" Size of deck " + testDeck.size());
            //System.out.println(" Size of deck for 4000 elements is " + ObjectSizeFetcher.getObjectSize(testDeck));
        }

        {
            Deque<Integer> testDeck = new Deque<>();
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 100000; i++) {
                testDeck.addLast(i);
            }

            System.out.println(" 100,000 addLast takes time " + stopwatch.elapsedTime());
            System.out.println(" Size of deck " + testDeck.size());
            //System.out.println(" Size of deck for 100,000 elements is " + ObjectSizeFetcher.getObjectSize(testDeck));
        }

    }

    @Test
    public void testRemoveLast() {

        {
            Deque<Integer> testDeck = new Deque<>();

            for (int i = 0; i < 1000; i++) {
                testDeck.addFirst(i);
            }

            System.out.println(" Size of deck before 1000 removeLast is " + testDeck.size());
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 1000; i++) {
                Assert.assertEquals((long) testDeck.removeLast(), i);
            }

            System.out.println(" 1000 removeLast takes time " + stopwatch.elapsedTime());
            System.out.println(" Size of deck after 1000 removeLast is " + testDeck.size());
        }

        {
            Deque<Integer> testDeck = new Deque<>();

            for (int i = 0; i < 2000; i++) {
                testDeck.addFirst(i);
            }

            System.out.println(" Size of deck before 2000 removeLast is " + testDeck.size());
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 2000; i++) {
                Assert.assertEquals((long) testDeck.removeLast(), i);
            }

            System.out.println(" 2000 removeLast takes time " + stopwatch.elapsedTime());
            System.out.println(" Size of deck after 2000 removeLast is " + testDeck.size());
        }

        {
            Deque<Integer> testDeck = new Deque<>();

            for (int i = 0; i < 4000; i++) {
                testDeck.addFirst(i);
            }

            System.out.println(" Size of deck before 4000 removeLast is " + testDeck.size());
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 4000; i++) {
                Assert.assertEquals((long) testDeck.removeLast(), i);
            }

            System.out.println(" 4000 removeLast takes time " + stopwatch.elapsedTime());
            System.out.println(" Size of deck after 4000 removeLast is " + testDeck.size());
        }

        {
            Deque<Integer> testDeck = new Deque<>();

            for (int i = 0; i < 100000; i++) {
                testDeck.addFirst(i);
            }

            System.out.println(" Size of deck before 100000 removeLast is " + testDeck.size());
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < 100000; i++) {
                Assert.assertEquals((long) testDeck.removeLast(), i);
            }

            System.out.println(" 100000 removeLast takes time " + stopwatch.elapsedTime());
            System.out.println(" Size of deck after 100000 removeLast is " + testDeck.size());
        }

    }

    @Test
    public void testExceptions() {
        Deque<Integer> testDeck = new Deque<>();

        try {
            testDeck.addFirst(null);
            Assert.fail("Exception expected");
        } catch (IllegalArgumentException ex) {
            //do nothing 
        } catch (Exception ex) {
            Assert.fail("Invalid exception");
        }

        try {
            testDeck.addLast(null);
            Assert.fail("Exception expected");
        } catch (IllegalArgumentException ex) {
            //do nothing 
        } catch (Exception ex) {
            Assert.fail("Invalid exception");
        }

        try {
            testDeck.removeFirst();
            Assert.fail("Exception expected");
        } catch (NoSuchElementException ex) {
            //do nothing 
        } catch (Exception ex) {
            Assert.fail("Invalid exception");
        }

        try {
            testDeck.removeLast();
            Assert.fail("Exception expected");
        } catch (NoSuchElementException ex) {
            //do nothing 
        } catch (Exception ex) {
            Assert.fail("Invalid exception");
        }
    }

    @Test
    public void testIterator() {
        Deque<Integer> testDeck = new Deque<>();

        for (int i = 0; i < 100000; i++) {
            testDeck.addFirst(i);
        }
        
        System.out.println(" Size of deck before iterating " + testDeck.size());
        int i=100000;
        for(Integer itr : testDeck ){
            Assert.assertEquals((long)itr, --i);
        }
        
        System.out.println(" Size of deck after iterating " + testDeck.size());
    }
}
