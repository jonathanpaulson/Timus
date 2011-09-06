import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P39 {
    static int[] f;
    static int[][] c;
    static int[] dp;
    static boolean[] dp_s;
    static List<Integer>[] cs;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        f = new int[n+1];
        for(int i=1; i<=n; i++)
            f[i] = in.nextInt();
        cs = (List<Integer>[]) new List[n+1];
        for(int i=0; i<=n; i++) cs[i] = new ArrayList<Integer>();
        dp = new int[n+1];
        dp_s = new boolean[n+1];
        boolean[] seen = new boolean[n+1];
        for(int i=0; i<n-1; i++) {
            int c = in.nextInt();
            int p = in.nextInt();
            seen[c] = true;
            cs[p].add(c);
        }
        for(int i=1; i<=n; i++)
            if(!seen[i])
                System.out.println(dp(i));
    }
    public static int dp(int n) {
        if(dp_s[n]) return dp[n];
        dp_s[n] = true;
    
        List<Integer> gcs = new ArrayList<Integer>();
        for(Integer c:cs[n])
            for(Integer gc:cs[c])
                gcs.add(gc);
        
        int c_sum = 0;
        for(Integer i:cs[n]) c_sum+=dp(i);
        int g_sum = 0;
        for(Integer i:gcs) g_sum+=dp(i);

        return dp[n] = max(f[n]+g_sum,c_sum);
    }
}
