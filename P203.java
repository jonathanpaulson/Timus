import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P203 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Point[] p = new Point[n];
        for(int i=0; i<n; i++)
            p[i] = new Point(in.nextInt(),in.nextInt());
        Arrays.sort(p,new Comparator<Point>() {
            public int compare(Point p1,Point p2) { return p1.y-p2.y; }
        });

        //System.out.println(Arrays.toString(p));
        int cnt = 1;
        int cur = p[0].y+1;
        for(int i=1; i<n; i++) {
            if(p[i].x >= cur) {
                cnt++;
                cur = p[i].y+1;
            }
        }
        System.out.println(cnt);
    }
}
