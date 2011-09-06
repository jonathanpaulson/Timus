import java.util.*;
import java.math.*;

public class P17 {
    static BigInteger[][] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dp = new BigInteger[n+1][n+1];
        System.out.println(solve(n,0).subtract(BigInteger.ONE));
    }
    public static BigInteger solve(int n,int k) {
        if(n==0) return BigInteger.ONE;
        if(n<k) return BigInteger.ZERO;
        if(dp[n][k] == null) {
            BigInteger ans = BigInteger.ZERO;
            for(int i=k+1; i<=n; i++)
                ans = ans.add(solve(n-i,i));
            dp[n][k] = ans;
        }
        return dp[n][k];
    }
}
