import java.util.*;
import java.awt.Point;
import java.math.*;
import java.awt.geom.*;

public class P719 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Point2D.Double[] pts = new Point2D.Double[4];
        for(int i=0; i<4; i++) {
            pts[i] = new Point2D.Double(in.nextDouble(),in.nextDouble());
        }
        double min = 40000;
        for(int i=0; i<4; i++)
            for(int j=i+1; j<4; j++) {
                double x=0,y=0;
                double dist = Line2D.ptLineDist(pts[i].x,pts[i].y,pts[j].x,pts[j].y,x,y);
                double angle = Math.atan2(pts[i].y-pts[j].y,pts[i].x-pts[j].x);
                angle -= Math.PI/2;
                int dir = Line2D.relativeCCW(pts[i].x,pts[i].y,pts[j].x,pts[j].y,x,y);
                if(dir==1) {
                    x+=dist*Math.cos(angle);
                    y+=dist*Math.sin(angle);
                } else {
                    x-=dist*Math.cos(angle);
                    y-=dist*Math.sin(angle);
                }

                int k = 0; while(k==i || k==j) k++;
                int l = 0; while(l==k || l==i || l==j) l++;
                double dist2 = Line2D.ptLineDist(pts[k].x,pts[k].y,pts[l].x,pts[l].y,x,y);
                min = Math.min(dist+dist2,min);
                System.out.println(pts[i]+" "+pts[j]+" "+x+" "+y+" "+(dist+dist2));
            }
        System.out.println(min);
    }
}
