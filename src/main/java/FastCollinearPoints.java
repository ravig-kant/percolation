
import edu.princeton.cs.algs4.MergeX;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
public class FastCollinearPoints {

    private final List<LineSegment> m_segments = new ArrayList<>();

    public FastCollinearPoints(Point[] i_points) {
        Point[] points = Arrays.copyOf(i_points, i_points.length);
        Arrays.sort(points);

        List<Point> ppoints = new ArrayList<>();
        List<Point> qpoints = new ArrayList<>();
        for (int i = 0; i < i_points.length; i++) {

            MergeX.sort(points, i_points[i].slopeOrder());

            //Loop all the slopes to find consecutive matching ones 
            //Start with one as ith object will be at the first index 
            for (int k = 1; k <= points.length - 1; k++) {
                List<Point> pointsOnLineSegment = new ArrayList<>();
                pointsOnLineSegment.add(points[0]);
                pointsOnLineSegment.add(points[k]);
                for (int j = k + 1; j < points.length; j++) {
                    Double slopeWithK = points[0].slopeTo(points[k]);
                    Double slopeWithJ = points[0].slopeTo(points[j]);
                    if (slopeWithK.equals(slopeWithJ)) {
                        pointsOnLineSegment.add(points[j]);
                    } else {
                        break;
                    }
                }
                if (pointsOnLineSegment.size() >= 4) {
                    Point[] arrayOfSelectedPoints = pointsOnLineSegment.toArray(new Point[pointsOnLineSegment.size()]);
                    Arrays.sort(arrayOfSelectedPoints);
                    ppoints.add(arrayOfSelectedPoints[0]);
                    qpoints.add(arrayOfSelectedPoints[arrayOfSelectedPoints.length - 1]);
                }
            }
        }
        if (ppoints.size() > 0) {
            Point[][] finalPoints = new Point[ppoints.size()][2];
            for (int finalPointsCtr = 0; finalPointsCtr < ppoints.size(); finalPointsCtr++) {
                finalPoints[finalPointsCtr][0] = ppoints.get(finalPointsCtr);
                finalPoints[finalPointsCtr][1] = qpoints.get(finalPointsCtr);
            }

            Arrays.sort(finalPoints, new Comparator<Point[]>() {
                @Override
                public int compare(Point[] o1, Point[] o2) {
                    if (o1[0].compareTo(o2[0]) != 0) {
                        return o1[0].compareTo(o2[0]);
                    }

                    return o1[1].compareTo(o2[1]);
                }

            });
            
            m_segments.add(new LineSegment(finalPoints[0][0], finalPoints[0][1]));
            Point prevppoint = finalPoints[0][0];
            Point prevqpoint = finalPoints[0][1];
            for(int dupCtr =1 ; dupCtr < ppoints.size(); dupCtr++){
                Point ppoint = finalPoints[dupCtr][0];
                Point qpoint = finalPoints[dupCtr][1];
                if(ppoint.compareTo(prevppoint) !=0 || qpoint.compareTo(prevqpoint) != 0){
                    m_segments.add(new LineSegment(ppoint, qpoint));
                    prevppoint = ppoint;
                    prevqpoint = qpoint;
                }
            }
        }
    }

    public int numberOfSegments() {
        return m_segments.size();
    }

    public LineSegment[] segments() {
        return m_segments.toArray(new LineSegment[0]);
    }

}
