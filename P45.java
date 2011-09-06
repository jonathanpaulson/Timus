import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P45 {
    static List<Integer> children[];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int root = in.nextInt()-1;
        children = new List[n];
        for(int i=0; i<n; i++) children[i] = new ArrayList<Integer>();
        Point[] edges = new Point[n-1];
        for(int i=0; i<n-1; i++)
            edges[i] = new Point(in.nextInt()-1,in.nextInt()-1);
        boolean[] seen = new boolean[n];
        seen[root] = true;
        for(int t=0; t<n-1; t++) {
            for(int i=0; i<edges.length; i++) {
                if(seen[edges[i].x] && !seen[edges[i].y]) {
                    children[edges[i].x].add(edges[i].y);
                    seen[edges[i].y]=true;
                }
                if(!seen[edges[i].x] && seen[edges[i].y]) {
                    children[edges[i].y].add(edges[i].x);
                    seen[edges[i].x]=true;
                }
            }
        }
        //for(int i=0; i<n; i++) System.out.println(i+" "+children[i]);
        Collections.sort(children[root]);
        for(int i=0; i<children[root].size(); i++) {
            if(dp(children[root].get(i))==0) {
                System.out.println("First player wins flying to airport "+(1+children[root].get(i)));
                return;
            }
        }
        System.out.println("First player loses");
    }
    public static int dp(int n) {
        Set<Integer> succ = new HashSet<Integer>();
        for(Integer i:children[n])
            succ.add(dp(i));
        //System.out.println(n+" "+succ+" "+children[n]);
        int ans = 0;
        while(succ.contains(ans)) ans++;
        return ans;
    }
}
