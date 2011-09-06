import java.util.*;

public class P73 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dp = new int[n+1];
        System.out.println(dp(n));
    }
    public static int dp(int n) {
        if(n<0) return Integer.MAX_VALUE;
        if(n==0) return 0;
        if(dp[n] == 0) {
            int min = Integer.MAX_VALUE;
            for(int i=1; i<=Math.sqrt(n); i++)
                if(dp(n-i*i)<min)
                    min = dp(n-i*i);
            dp[n] = 1+min;
        }
        return dp[n];
    }
}
