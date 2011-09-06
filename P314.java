import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P314 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		Map<Integer,Set<Integer>> edges = new HashMap<Integer,Set<Integer>>();

		int n = in.nextInt();
		for(int i=0; i<n; i++) {
			int k = in.nextInt();
			int prev = in.nextInt();
			if(!edges.containsKey(prev))
				edges.put(prev,new HashSet<Integer>());
			for(int j=1; j<k; j++) {
				int next = in.nextInt();
				if(!edges.containsKey(next))
					edges.put(next,new HashSet<Integer>());
				edges.get(prev).add(next);
				edges.get(next).add(prev);
				prev = next;
			}
		}
		
		int m = in.nextInt();
		int start=in.nextInt();
		for(int i=1; i<m-1; i++)
			in.nextInt();
		int end;
		if(m>1) end = in.nextInt();
		else end=start;


		Set<Integer> seen = new HashSet<Integer>();
		Map<Integer,Integer> ds = new HashMap<Integer,Integer>();
		Map<Integer,Integer> de = new HashMap<Integer,Integer>();
		
		Queue<Point> Q = new LinkedList<Point>();
		Q.offer(new Point(start,0));
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			seen.add(p.x);
			ds.put(p.x,p.y);
			for(Integer i:edges.get(p.x))
				if(!seen.contains(i))
					Q.offer(new Point(i,p.y+1));
		}

		seen.clear();
		Q.offer(new Point(end,m-1));
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			seen.add(p.x);
			de.put(p.x,p.y);
			for(Integer i:edges.get(p.x))
				if(!seen.contains(i))
					Q.offer(new Point(i,p.y+1));
		}

		List<Integer> ans = new ArrayList<Integer>();
		for(Integer i:edges.keySet()) {
			if(ds.containsKey(i) && de.containsKey(i) && ds.get(i).equals(de.get(i)))
				ans.add(i);
		}
		Collections.sort(ans);
		for(Integer i:ans)
			System.out.println(i);
    }
}
