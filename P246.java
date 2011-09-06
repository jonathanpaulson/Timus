import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;
import java.io.*;

public class P246 {
    public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Point[] pts = new Point[n];
		int best_i = 0;
		for(int i=0; i<n; i++) {
			String[] arr = in.readLine().split(" ");
			pts[i] = new Point(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));
			if(pts[i].y > pts[best_i].y) best_i = i;
		}
		System.out.println(CCW(pts[(best_i+n-1)%n],pts[best_i],pts[(best_i+1)%n])<0?"cw":"ccw");
    }
	public static int CCW(Point a,Point b,Point c) {
		Point b2 = new Point(b.x-a.x,b.y-a.y);
		Point c2 = new Point(c.x-a.x,c.y-a.y);
		long score = (long)b2.x*(long)c2.y-(long)b2.y*(long)c2.x;
		if(score < 0) return -1;
		if(score > 0) return 1;
		return 0;
	}
}
