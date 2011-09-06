import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P160 {
	static int[] uf;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		uf = new int[n];
		for(int i=0; i<n; i++)
			uf[i] = i;
		List<Edge> edges = new ArrayList<Edge>();
		for(int i=0; i<m; i++) {
			edges.add(new Edge(in.nextInt()-1,in.nextInt()-1,in.nextInt()));
		}
		Collections.sort(edges,new Comparator<Edge>() {
			public int compare(Edge a,Edge b) {
				return a.weight-b.weight;
			}
		});
		int max=0;
		List<Edge> used = new ArrayList<Edge>();
		for(Edge e:edges) {
			if(find(e.start)==find(e.end)) continue;
			mix(e.start,e.end);
			used.add(e);
			max = e.weight;
		}
		System.out.println(max);
		System.out.println(used.size());
		for(Edge e:used)
			System.out.println( (e.start+1)+" "+(e.end+1));
    }
	public static int find(int x) {
		if(uf[x]==x) return x;
		return uf[x]=find(uf[x]);
	}
	public static void mix(int a,int b) {
		uf[find(a)]=find(b);
	}
	public static class Edge {
		int start;
		int end;
		int weight;
		public Edge(int s,int e,int w) {
			start=s;
			end=e;
			weight=w;
		}
	}
}
