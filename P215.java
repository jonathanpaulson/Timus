import java.util.*;
import static java.lang.Math.*;

public class P215 {
	static double EPS = 1e-9;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Point p = new Point(in.nextDouble(),in.nextDouble());
		int n = in.nextInt();
		Point[] pts = new Point[n];
		for(int i=0; i<n; i++)
			pts[i] = new Point(in.nextDouble(),in.nextDouble());
		double min = point_in_poly(p,pts)?0:10000;
		for(int i=0; i<n; i++) {
			min = min(min,point_line_dist(pts[i],pts[(i+1)%n],p));
		}
		System.out.printf("%.3f\n",2*min);
	}

	static class Point {
		double x,y;
		public Point(double x,double y) {
			this.x = x;
			this.y = y;
		}
		public double length() { return sqrt(x*x+y*y); }
		public Point add(Point o) {
			return new Point(x+o.x,y+o.y);
		}
		public Point sub(Point o) {
			return new Point(x-o.x,y-o.y);
		}
		public Point scale(double by) {
			return new Point(x*by,y*by);
		}
		public Point normal() { return scale(1/length()); }
		public Point orthonormal() {
			return new Point(-y,x).normal();
		}
		public double distance(Point o) {
			return sub(o).length();
		}
		public String toString() { return "["+x+" "+y+"]"; }
	}
	static double cross(Point a,Point b) {
		return a.x*b.y-a.y*b.x;
	}
	static double dot(Point a,Point b) { //projects a onto the unit vector b
		return a.x*b.x+a.y*+b.y;
	}
	static int ccw(Point a,Point b,Point c) {
		Point v1 = b.sub(a); 
		Point v2 = c.sub(a); 
		double cross = cross(v1,v2); 
		if(abs(cross) < EPS)
			return 0; 
		if(cross <= -EPS) 
			return -1; 
		return 1; 
	}
	static Point rotate(Point a,double theta) { //counterclockwise
		// x+iy -> (x+iy)(cos(theta)+i*sin(theta))
		double x2 = a.x*cos(theta) - a.y*sin(theta);
		double y2 = a.y*cos(theta) + a.x*sin(theta);
		return new Point(x2,y2);
	}

	public static double point_line_dist(Point a,Point b,Point c) {
		//Point p = rotate(b.sub(a),90).normal();
		//return abs(dot(p,c)-dot(p,a));
		Point b2 = b.sub(a);
		double scale = dot(b2,c.sub(a))/b2.length()/b2.length();
		if(scale < 0 || scale>1) return min(c.distance(a),c.distance(b));	
		Point p = a.add( b2.scale(scale));
		return c.distance(p);
	}

	public static boolean point_in_poly(Point p,Point[] poly) { //If poly convex
		int first = ccw(poly[0],poly[1],p);
		for(int i=0; i<poly.length; i++) {
			if(ccw(poly[i],poly[(i+1)%poly.length],p) != first)
				return false;
		}
		return true;
	}
}
