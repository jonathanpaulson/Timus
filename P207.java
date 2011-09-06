import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;
import java.awt.geom.*;

public class P207 {
    static double EPS=1e-9;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Point[] pts = new Point[n];
        for(int i=0; i<n; i++)
            pts[i] = new Point(in.nextInt(),in.nextInt());
        
        int index = 0;
        for(int i=0; i<n; i++)
            if(pts[i].x < pts[index].x)
                index = i;
        List<Point2D.Double> angles = new ArrayList<Point2D.Double>();
        for(int i=0; i<n; i++)
            if(i != index)
                angles.add(new Point2D.Double( atan2(pts[i].y-pts[index].y,pts[i].x-pts[index].x) ,i));
        Collections.sort(angles,new Comparator<Point2D.Double>() {
            public int compare(Point2D.Double a,Point2D.Double b) {
            double ans = a.x-b.x;
            if(abs(ans) < EPS) return 0;
            if(ans < 0) return -1;
            return 1;
        }});
  //System.out.println(angles);
        System.out.println((index+1)+" "+(1+(int)angles.get((n-1)/2).y));
        
    }
}
