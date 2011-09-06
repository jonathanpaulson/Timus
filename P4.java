import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P4 {
	static int INF = Integer.MAX_VALUE/5;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		while(true) {
			int best = INF;
			List<Integer> cycle = new ArrayList<Integer>();			

			int n = in.nextInt();
			if(n==-1) break;
			int m = in.nextInt();
			int[][] costs = new int[n+1][n+1];
			for(int i=0; i<costs.length; i++)
				for(int j=0; j<costs[i].length; j++)
					costs[i][j] = INF;
			
			for(int i=0; i<m; i++) {
				int start = in.nextInt();
				int end = in.nextInt();
				int dist = in.nextInt();
				costs[start][end] = dist;
				costs[end][start] = dist;
			}

			for(int start=1; start<=n; start++) {
				for(int end=1; end<=n; end++) {
					if(costs[start][end] == INF) continue;
					
					int old_cost = costs[start][end];
					costs[start][end] = INF;

					int[] dist = new int[n+1];
					boolean[] seen = new boolean[n+1];
					for(int i=1; i<=n; i++) dist[i] = INF;
					dist[start] = 0;
					for(int j=0; j<n; j++) {
						int min = 1;
						while(seen[min]) min++;
						for(int i=1; i<=n; i++)
							if(dist[i] < dist[min] && !seen[i]) min = i;
						seen[min] = true;
						for(int i=1; i<=n; i++)
							dist[i] = Math.min(dist[i],dist[min]+costs[min][i]);
					}
					if(dist[end]+old_cost < best && dist[end]!=INF) {
						best = dist[end]+old_cost;
						cycle.clear();
						while(end != start) {
							cycle.add(end);
							INNER: for(int i=1; i<=n; i++)
								if(dist[i]+costs[i][end] == dist[end])
									{ end=i; break INNER; }
						}
						cycle.add(start);
					}
					costs[start][end] = old_cost;
				}
			}

			if(best == INF)
				System.out.println("No solution.");
			else {
				for(int i=0; i<cycle.size(); i++)
					System.out.print(cycle.get(i)+(i==cycle.size()-1?"":" "));
				System.out.println();
			}
		}
    }
}
