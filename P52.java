import java.util.*;
import java.awt.*;

public class P52 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Point[] pts = new Point[n];
        for(int i=0; i<n; i++)
            pts[i] = new Point(in.nextInt(),in.nextInt());
        int max = 2;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int score = 0;
                double slope = ((double)(pts[i].y-pts[j].y))/(pts[i].x-pts[j].x);
                double yint = pts[i].y-slope*pts[i].x;
                for(int k=0; k<n; k++)
                    if(equal(slope*pts[k].x+yint,pts[k].y))
                        score++;
                if(score > max)
                    max = score;
            }
        }
        System.out.println(max);
    }
    public static boolean equal(double a,double b) {
        return Math.abs(a-b) < 0.0001;
    }
}
