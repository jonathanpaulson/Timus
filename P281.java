import java.util.*;
import static java.lang.Math.*;

public class P281 {
	static double EPS = 1e-9;
	static Point[][] rivers;
	static int[] uf;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		rivers = new Point[n][];
		uf = new int[n];
		for(int i=0; i<n; i++) uf[i]=i;
		for(int i=0; i<n; i++) {
			int k = in.nextInt();
			rivers[i] = new Point[k];
			for(int j=0; j<k; j++)
				rivers[i][j] = new Point(in.nextDouble(),in.nextDouble());
		}
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				if(connected(i,j)) group(i,j);
		//System.out.println(Arrays.toString(uf));
		double max = 0;
		for(int i=0; i<n; i++) {
			Set<Point> list = new HashSet<Point>();
			for(int j=0; j<n; j++)
				if(find(i)==find(j)) {
					list.addAll(Arrays.asList(rivers[j]));
				}
			Point[] pts = list.toArray(new Point[]{});
			Point[] hull = hull(pts);
			max = max(max,area(hull));
		}
		System.out.printf("%.2f\n",max);
	}
	public static void group(int a,int b) {
		uf[find(a)]=find(b);
	}
	public static int find(int x) {
		if(uf[x]==x) return x;
		return uf[x]=find(uf[x]);
	}
	public static boolean connected(int a,int b) {
		Set<Point> set = new HashSet<Point>();
		for(int i=0; i<rivers[a].length; i++)
			set.add(rivers[a][i]);
		for(int i=0; i<rivers[b].length; i++)
			if(set.contains(rivers[b][i]))
				return true;
		return false;
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
		public boolean equals(Object o) {
			if(!(o instanceof Point)) return false;
			Point p = (Point)o;
			return abs(x-p.x)<EPS && abs(y-p.y)<EPS;
		}
		public int hashCode() {
			return (int)x+1000*(int)y;
		}
		public String toString() { return "["+x+" "+y+"]"; }
	}
	static double cross(Point a,Point b) {
		return a.x*b.y-a.y*b.x;
	}
	static double dot(Point a,Point b) { //projects a onto the unit vector b
		return a.x*b.x+a.y*b.y;
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

	public static double signed_area(Point[] pts) {
		double area = 0;
		for(int i=0; i<pts.length; i++)
			area += cross(pts[i],pts[(i+1)%pts.length])/2;
		return area;
	}
	public static double area(Point[] poly) { return abs(signed_area(poly)); }

	/* Graham Scan */
	public static Point[] hull(Point[] pts) {
		/* Find point with lowest y-coord; tiebreak by lowest x-coord */
		Point min = pts[0];
		for(int i=0; i<pts.length; i++)
			if(pts[i].y < min.y || (abs(pts[i].y-min.y)<EPS && pts[i].x<min.x))
				min = pts[i];
		final Point p = min;
		Arrays.sort(pts,new Comparator<Point>() {
			public int compare(Point a,Point b) { 
				double sa = score(a);
				double sb = score(b);
				if(abs(sa-sb)<EPS) return 0;
				return sa<sb?-1:1;
			}
			public double score(Point a) {
				if(a.equals(p)) return -100;
				Point a2 = a.sub(p);
				Point x = new Point(1,0);
				return dot(a2,x)/a2.length();
			}
		});
		Stack<Point> S = new Stack();
		for(int i=0; i<pts.length; i++) {
			while(S.size()>=2 && ccw(S.get(S.size()-2),S.peek(),pts[i])!=-1) {
				S.pop();
			}
			S.push(pts[i]);
		}
		Point[] ret = new Point[S.size()];
		return S.toArray(ret);
		//For lower hull, negate y-values
	}
}
