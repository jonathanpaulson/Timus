import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P500 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		int n = in.nextInt();
		int m = in.nextInt();

		int min = k;
		int best = 0;
		int[][] adj = new int[k][n];
		for(int i=0; i<m; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			int cat = in.nextInt();
			adj[cat][start] |= (1<<end);
			adj[cat][end]   |= (1<<start);
		}

		int lim = 2<<k;
		OUTER: for(int A=0; A<lim; A++) {
			int[] E = new int[n];
			int count=0;
			for(int i=0; i<k; i++) {
				if( ((A>>i)&1)==0 ) continue;
				count++;
				if(count >= min) continue OUTER;
				for(int j=0; j<adj[i].length; j++)
					E[j] |= adj[i][j];
			}
			
			int visited = 1;
			for(int i=0; i<n; i++) {
				for(int v=0; v<n; v++) {
					if( ((visited>>v)&1)==0 ) continue;
					visited |= E[v];
				}
			}
			if( ((visited>>1)&1) == 1) {
				min = count;
				best = A;
			}
		}
		System.out.println(min);
		for(int i=0; i<k; i++)
			if( ((best>>i)&1)==1 )
				System.out.print(i+" ");
		System.out.println();
	}
}
