import java.util.*;
import java.awt.Point;
import java.math.*;

public class P31 {
    static int L1,L2,L3,C1,C2,C3;
    static int n;
    static int[] dist;
    static long[] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        L1 = in.nextInt();
        L2 = in.nextInt();
        L3 = in.nextInt();
        C1 = in.nextInt();
        C2 = in.nextInt();
        C3 = in.nextInt();
        n = in.nextInt();
        int start = in.nextInt();
        int end = in.nextInt();
        dist = new int[n];
        dp = new long[n];
        for(int i=1; i<n; i++) dist[i] = in.nextInt();
        System.out.println(start<end?dp(start-1,end-1):dp(end-1,start-1));
    }
    public static long dp(int start,int end) {
        if(start > end) return Integer.MAX_VALUE;
        if(start == end) return 0;
        if(dp[start] > 0) return dp[start];
        long ans = Integer.MAX_VALUE;
        for(int i=start+1; i<n && dist[i]-dist[start]<=L3; i++) {
            if(dist[i]-dist[start] <= L1) ans = Math.min(ans,C1+dp(i,end));
            else if(dist[i]-dist[start] <= L2) ans = Math.min(ans,C2+dp(i,end));
            else ans = Math.min(ans,C3+dp(i,end));
        }
        return dp[start] = ans;
    }
}
