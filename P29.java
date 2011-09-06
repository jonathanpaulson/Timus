import java.util.*;
import java.awt.Point;
import java.math.*;

public class P29 {
	static long[][] dist;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] cost = new int[m][n];
		dist = new long[m][n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                cost[i][j] = in.nextInt();
		boolean[][] seen = new boolean[m][n];
		Queue<PP> Q = new PriorityQueue<PP>(m*n,new PCMP());
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				dist[i][j] = Long.MAX_VALUE/10;
		for(int i=0; i<n; i++) dist[0][i] = cost[0][i];
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				Q.offer(new PP(i,j,dist[i][j]));
		for(int i=0; i<m*n; i++) {
			PP p = null;
			do { p = Q.poll(); } while(seen[p.x][p.y]);
			seen[p.x][p.y]=true;
			int r = p.x;
			int c = p.y;
			if(r<m-1 && !seen[r+1][c] && dist[r][c]+cost[r+1][c] < dist[r+1][c]) { dist[r+1][c] = dist[r][c]+cost[r+1][c]; Q.offer(new PP(r+1,c,dist[r+1][c])); }
			if(c>0   && !seen[r][c-1] && dist[r][c]+cost[r][c-1] < dist[r][c-1]) { dist[r][c-1] = dist[r][c]+cost[r][c-1]; Q.offer(new PP(r,c-1,dist[r][c-1])); }
			if(c<n-1 && !seen[r][c+1] && dist[r][c]+cost[r][c+1] < dist[r][c+1]) { dist[r][c+1] = dist[r][c]+cost[r][c+1]; Q.offer(new PP(r,c+1,dist[r][c+1])); }
		}

		int r = m-1;
		int c =0;
		for(int i=0; i<n; i++)
			if(dist[r][i] < dist[r][c])
				c = i;
		List<Integer> ans = new ArrayList<Integer>();
		ans.add(c);
		while(r>0) {
			if(dist[r-1][c] + cost[r][c] == dist[r][c]) r--;
			else if(c>0 && dist[r][c-1]+cost[r][c] == dist[r][c]) c--;
			else if(c<n-1 && dist[r][c+1]+cost[r][c] == dist[r][c]) c++;
			ans.add(0,c);
		}
		for(int i=0; i<ans.size(); i++)
			System.out.print( (ans.get(i)+1)+(i==ans.size()-1?"":" "));
		System.out.println();
    }
	public static long min(long a,long b) { return a<b?a:b; }
	private static class PP {
		int x,y;
		long p;
		public PP(int x,int y,long p) {
			this.x=x; this.y=y; this.p=p;
		}
	}
	private static class PCMP implements Comparator<PP> {
		public int compare(PP a,PP b) {
			long score = a.p-b.p;
			if(score > 0) return 1;
			if(score < 1) return -1;
			return 0;
		}
	}
}
