import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P742 {
    static boolean[] S;
    static boolean[] cycle;
    static int cycle_cnt;
    static int[] f;       

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[] seen = new boolean[n];
        cycle = new boolean[n];
        f = new int[n];
        for(int i=0; i<n; i++) {
            int num = in.nextInt()-1;
            seen[num] = true;
            f[i] = num;
        }

        boolean[] min_S = new boolean[n];
        int min = 0;
        for(int i=0; i<n; i++)
            if(!seen[i]) {
                min++;
                int x = i;
                while(!min_S[x]) {
                    min_S[x] = true;
                    x = f[x];
                }
            }
        for(int i=0; i<n; i++) {
            if(!min_S[i]) {
                min++;
                int x = i;
                while(!min_S[x]) {
                    min_S[x] = true;
                    x = f[x];
                }
            }
        }

        S = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!S[i])
                dfs(i);
        }

        int max = cycle_cnt;
        for(int i=0; i<n; i++)
            if(!cycle[i])
                max++;

        System.out.println(min+" "+max);
    }

    public static void dfs(int x) {
        Set<Integer> L = new HashSet<Integer>();
        while(!L.contains(x)) {
            if(S[x]) return;
            L.add(x);
            S[x] = true;
            x = f[x];
        }
        if(cycle[x]) return;

        cycle_cnt++;
        do {
            cycle[x] = true;
            x = f[x];
        } while(!cycle[x]);
    }
}
