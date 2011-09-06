import java.util.*;
import java.awt.Point;
import java.math.*;

public class P225 {
    static long[] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dp = new long[n+1];
        for(int i=0; i<n; i++) dp[i]=-1;
        System.out.println(2*dp(n));
    }
    public static long dp(int n) {
        if(n<=0) return 0;
        if(n<=2) return 1;
        if(dp[n]>0) return dp[n];
        return dp[n]=dp(n-1)+dp(n-2);
    }
}
