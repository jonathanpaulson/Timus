import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

/* Same as 1182 */
public class P156 {
	static boolean[] seen;
	static boolean[] color;
	static boolean[][] edges;
	static boolean bad;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		edges = new boolean[2*n][2*n];
		int m=in.nextInt();
		for(int i=0; i<m; i++) {
			int start=in.nextInt()-1;
			int end=in.nextInt()-1;
			edges[start][end]=true;
			edges[end][start]=true;
		}
		seen = new boolean[2*n];
		for(int i=0; i<2*n; i++)
			if(!seen[i]) {
				color[i]=true;
				dfs(i);
			}
		if(bad) { System.out.println("IMPOSSIBLE"); }
		Set<Integer> one = new HashSet<Integer>();
		Set<Integer> two = new HashSet<Integer>();
		for(int i=0; i<2*n; i++) {
			if(color[i]) one.add(i);
			else two.add(i);
		}
    }
	public static void dfs(int x) {
		seen[x]=true;
		for(int i=0; i<2*n; i++) {
			if(seen[i] && (color[i]==color[x]))
				bad=true;
			if(!seen[i]) {
				color[i]=!color[x];
				dfs(x);
			}
		}
	}
}
