import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P709 {
	static int[] uf;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int n = in.nextInt(); in.nextLine();
		int d = in.nextInt();
		int a = in.nextInt(); in.nextLine();
		Set<Point> edges = new HashSet<Point>();
		for(int i=0; i<n; i++) {
			String line = in.nextLine();
			for(int j=0; j<n; j++)
				if(line.charAt(j)=='1' && !edges.contains(new Point(j,i)))
					edges.add(new Point(i,j));
		}

		long cost=0;
		Set<Point> del = new HashSet<Point>();
		Set<Point> add = new HashSet<Point>();
		uf = new int[n];
		for(int i=0; i<n; i++) uf[i]=i;
		for(Point e:edges) {
			if(find(e.x)==find(e.y)) {
				del.add(e);
				cost+=d;
			}
			else mix(e.x,e.y);
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(find(i)!=find(j)) {
					mix(i,j);
					add.add(new Point(i,j));
					cost+=a;
				}
			}
		}
		System.out.println(cost);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(del.contains(new Point(i,j)) || del.contains(new Point(j,i)))
					System.out.print("d");
				else if(add.contains(new Point(i,j)) || add.contains(new Point(j,i)))
					System.out.print("a");
				else System.out.print("0");
			}
			System.out.println();
		}
    }
	public static void mix(int a,int b) {
		uf[find(a)]=find(b);
	}
	public static int find(int x) {
		if(uf[x]==x) return x;
		return uf[x]=find(uf[x]);
	}
}
