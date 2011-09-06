import java.util.*;

public class P138 {
    static int n;
    static int[] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int s = in.nextInt();
        dp = new int[n+1];
        System.out.println(dp(s));
    }
    public static int dp(int k) {
        if(dp[k]>0) return dp[k];
        if(k==n) return 1;
        int max = 0;
        for(int i=k+1; i<=n; i++) {
            double d = (((double)i)/k-1) * 100;
            if(Math.abs(d-(int)(d+0.5))<1e-5 && d<=100 && dp(i)>max)
                max = dp(i);
        }
        return dp[k] = max+1;
    }
}
