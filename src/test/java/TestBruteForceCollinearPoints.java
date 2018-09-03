/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class TestBruteForceCollinearPoints {

    public TestBruteForceCollinearPoints() {
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
    public void testLineSegments() {

        Path path = Paths.get("C:\\Users\\ravigu\\Coursera\\Algorithms\\Assignments\\Sort\\Test\\collinear");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path, "input8.txt")) {
            stream.forEach(new Consumer<Path>() {
                @Override
                public void accept(Path t) {
                    In in = new In(t.toString());      // input file
                    int n = in.readInt();
                    Point[] points = new Point[n];
                    for (int i = 0; i < n; i++) {
                        int x = in.readInt();
                        int y = in.readInt();
                        points[i] = new Point(x, y);
                    }

                    // draw the points
                    StdDraw.enableDoubleBuffering();
                    StdDraw.setXscale(0, 32768);
                    StdDraw.setYscale(0, 32768);
                    for (Point p : points) {
                        p.draw();
                    }
                    StdDraw.show();

                    // print and draw the line segments
                    BruteCollinearPoints collinear = new BruteCollinearPoints(points);
                    for (LineSegment segment : collinear.segments()) {
                        StdOut.println(segment);
                        segment.draw();
                    }
                    StdDraw.show();
                    StdDraw.pause(10000);
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(TestBruteForceCollinearPoints.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
