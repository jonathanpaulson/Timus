import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P56 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] C = new int[n+1];
        int[] P = new int[n+1];
        for(int i=2; i<=n; i++) {
            int x = in.nextInt();
            C[x]++;
            P[i] = x;
        }

        Queue<Integer> Q = new LinkedList<Integer>();
        for(int i=1; i<=n; i++)
            if(C[i] == 0)
                Q.offer(i);
        Set<Integer> N = new HashSet<Integer>();
        for(int i=1; i<=n; i++)
            N.add(i);
        Queue<Integer> Q2 = new LinkedList<Integer>();
        while(true) { 
            if(N.size() <= 2)
                break;
            while(!Q.isEmpty()) {
                System.out.println(Q+" "+Arrays.toString(C));
                Integer x = Q.poll();
                C[P[x]]--;
                if(C[P[x]] == 0)
                    Q2.offer(P[x]);
                N.remove(x);
            }
            Q = new LinkedList<Integer>(Q2);
        }

        List<Integer> ans = new ArrayList<Integer>(N);
        for(int i=0; i<ans.size(); i++)
            System.out.print(ans.get(i)+(i==ans.size()-1?"\n":" "));
    }
}
