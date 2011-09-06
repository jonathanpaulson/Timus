import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P182 {
	static int n;
	static LinkedList<Set<Integer>> first;
	static LinkedList<Set<Integer>> second;
	static boolean[] seen;
	static int[] color;
	static boolean[][] e;
	static boolean bad;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		n = in.nextInt();
		boolean[][] edges = new boolean[n][n];
		for(int i=0; i<n; i++) {
			while(true) {
				int num = in.nextInt()-1;
				if(num==-1) break;
				edges[i][num] = true;
			}
		}
		e = new boolean[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				if( (!edges[i][j] || !edges[j][i]) && i!=j)
					e[i][j] = true;

		first = new LinkedList<Set<Integer>>();
		second = new LinkedList<Set<Integer>>();
		seen = new boolean[n];
		for(int i=0; i<n; i++) {
			while(i<n && seen[i]) i++;
			if(i==n) break;
			color = new int[n];
			color[i]=1;	
			dfs(i);
			if(bad) { System.out.println("No solution"); return; }
			first.add(new HashSet<Integer>());
			second.add(new HashSet<Integer>());
			for(int j=0; j<n; j++) {
				if(color[j]==1) first.getLast().add(j);
				if(color[j]==2) second.getLast().add(j);
			}
		}

		int k = first.size();
		int[] d = new int[k];
		int sum = 0;
		for(int i=0; i<k; i++) {
			d[i]=first.get(i).size()-second.get(i).size();
			sum+=abs(d[i]);
		}

		Map<Integer,Point> back = new HashMap<Integer,Point>();
		boolean[] can = new boolean[2*sum+1];
		can[2*sum]=true;
		for(int i=0; i<k; i++) {
			for(int j=0; j<=2*sum; j++) {
				if(can[j]) {
					if(d[i]>0) {
						can[j-2*d[i]]=true;
						back.put(j-2*d[i],new Point(j,-(i+1)));
					}
					else {
						can[j+2*d[i]]=true;
						back.put(j+2*d[i],new Point(j,(i+1)));
					}
				}
			}
		}

		List<Integer> T1 = new ArrayList<Integer>();
		List<Integer> T2 = new ArrayList<Integer>();
		for(int i=0; i<first.size(); i++) {
			T1.addAll(first.get(i));
			T2.addAll(second.get(i));
		}
		int max = 0;
		for(int i=0; i<=2*sum; i++) {
			if(can[i] && abs(i-sum)<abs(max-sum))
				max = i;
		}
		while(back.containsKey(max)) {
			Point p = back.get(max);
			back.remove(max);
			max = p.x;
			if(p.y>0) {
				T2.removeAll(second.get(p.y-1));
				T1.removeAll(first.get(p.y-1));
				T1.addAll(second.get(p.y-1));
				T2.addAll(first.get(p.y-1));
			}
			else {
				T2.removeAll(second.get(-p.y-1));
				T1.removeAll(first.get(-p.y-1));
				T2.addAll(first.get(-p.y-1));
				T1.addAll(second.get(-p.y-1));
			}
		}
		System.out.print(T1.size()+" ");
		for(int i=0; i<T1.size(); i++)
			System.out.print( (1+T1.get(i))+(i==T1.size()-1?"":" "));
		System.out.println();
		System.out.print(T2.size()+" ");
		for(int i=0; i<T2.size(); i++)
			System.out.print( (1+T2.get(i))+(i==T2.size()-1?"":" "));
		System.out.println();
    }
	public static void dfs(int x) {
		seen[x]=true;
		for(int i=0; i<n; i++) {
			if(e[x][i]) {
				if(color[i]==color[x]) bad=true;
				color[i] = color[x]==1?2:1;
				if(!seen[i])
					dfs(i);
			}
		}
	}
}
