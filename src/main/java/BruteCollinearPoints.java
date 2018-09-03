
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ravigu
 */
public class BruteCollinearPoints {

    private final List<LineSegment> segments = new ArrayList<>();

    public BruteCollinearPoints(Point[] i_points) {
        
        if (i_points == null || i_points[0] == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        Point[] points = new Point[i_points.length];
        for (int cnt = 0; cnt < points.length; cnt++) {
            points[cnt]=i_points[cnt];
            if(points[cnt] == null)
                throw new IllegalArgumentException("Invalid input. A point in input is null");           
        }
        Arrays.sort(points);
        
        for (int cnt1 = 0; cnt1 < points.length-1; cnt1++) {
            if(points[cnt1].compareTo(points[cnt1+1]) == 0)
                throw new IllegalArgumentException("Invalid input. Duplicate entry");           
        }

        Point[] fourPoints = new Point[4];
        Double[] slopes = new Double[3];

        for (int i = 0; i < points.length; i++) {
            fourPoints[0] = points[i];

            for (int j = i+1; j < points.length; j++) {
                fourPoints[1] = points[j];
                slopes[0] = points[i].slopeTo(points[j]);

                for (int k = j+1; k < points.length; k++) {
                    fourPoints[2] = points[k];
                    slopes[1] = points[i].slopeTo(points[k]);
                    if (!slopes[0].equals(slopes[1])) {
                        continue;
                    }

                    for (int n = k+1; n < points.length; n++) {
                        fourPoints[3] = points[n];
                        slopes[2] = points[i].slopeTo(points[n]);
                        if (!slopes[1].equals(slopes[2])) {
                            continue;
                        }

                        // Four points on the same line segment found 
                        //Arrange them in Ascending order 
                        Arrays.sort(fourPoints, 0, 4);
                        for (int m = 0; m < 3; m++) {
                            if (fourPoints[m] == fourPoints[m + 1]) {
                                throw new IllegalArgumentException("Matching input");
                            }
                        }

                        //TODO Check duplicate points and throw exception
                        segments.add(new LineSegment(fourPoints[0], fourPoints[3]));
                    }

                }
            }
        }
    }

    public int numberOfSegments() {
        return segments.size();
    }
    
    public LineSegment[] segments()  {
        return segments.toArray(new LineSegment[0]);
    }
}
