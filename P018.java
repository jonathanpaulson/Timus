import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P18 {
	static List<Point>[] E;
	static long[][] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int Q = in.nextInt();
		int[][] edges = new int[N][3];
		dp = new long[N+1][Q+1];
		for(int i=0; i<=N; i++)
			for(int j=0; j<=Q; j++)
				dp[i][j]=-1;

		for(int i=0; i<N-1; i++)
			edges[i] = new int[]{in.nextInt(),in.nextInt(),in.nextInt()};
		Set<Integer> seen = new HashSet<Integer>();
			seen.add(1);
		E = (List<Point>[]) new ArrayList[N+1];
		for(int i=1; i<=N; i++)
			E[i] = new ArrayList<Point>();
		while(seen.size()<N) {
			for(int i=0; i<N; i++) {
				if(seen.contains(edges[i][0])) {
					E[edges[i][0]].add(new Point(edges[i][1],edges[i][2]));	
					seen.add(edges[i][1]);
				}
				else if(seen.contains(edges[i][1])) {
					E[edges[i][1]].add(new Point(edges[i][0],edges[i][2]));	
					seen.add(edges[i][0]);
				}
			}
		}
		System.out.println(dp(1,Q));
    }

	public static long dp(int root,int Q) {
		//System.out.println(root+" "+Q);
		List<Point> C = E[root];
		if(dp[root][Q]>=0) return dp[root][Q];
		if(C.size()==0 || Q==0) return 0;

		long ans = C.get(0).y+dp(C.get(0).x,Q-1);
		if(C.size()==1) return dp[root][Q]=ans;
		ans = max(ans,C.get(1).y+dp(C.get(1).x,Q-1));
		for(int i=0; i<=Q-2; i++) {
			ans = max(ans,C.get(0).y+C.get(1).y+dp(C.get(0).x,i)+dp(C.get(1).x,Q-2-i));
		}
		return dp[root][Q] = ans;
	}
}
