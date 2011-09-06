import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P362 {
	static int[][] edges;
	static boolean[] visited;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		edges = new int[n+1][];
		visited = new boolean[n+1];

		int[] tmp = new int[2*n-1];
		for(int i=0; i<2*n-1; i++)
			tmp[i] = in.nextInt();
		int v=1;
		int d=0;
		for(int i=0; i<2*n-1; i++) {
			while(tmp[i]!=0) {i++; d++;}
			edges[v++] = new int[d+1];
			d=0;
		}
		v=1;
		for(int i=0; i<2*n-1; i++) {
			for(int j=1; j<edges[v].length; j++,i++) {
				edges[v][j]=tmp[i];
				edges[tmp[i]][0]=v;
			}
			v++;
		}
		visited[0]=true;
		System.out.println(dp(in.nextInt()));
    }
	public static int dp(int n) {
		visited[n] = true;
		List<Integer> children = new ArrayList<Integer>();
		for(int i=0; i<edges[n].length; i++) {
			if(!visited[edges[n][i]])
				children.add(dp(edges[n][i]));
		}
		if(children.size()==0) return 0;
		Collections.sort(children,new Comparator<Integer>() {
			public int compare(Integer a,Integer b) {
				return b-a;
			}
		});
		int min = children.get(0)+1;
		for(int i=1; i<children.size(); i++) {
			min = max(min,children.get(i)+i+1);
		}
		return min;
	}
}
