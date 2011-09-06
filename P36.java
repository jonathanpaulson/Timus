import java.util.*;
import java.awt.Point;
import java.math.*;

public class P36 {
    static BigInteger[][] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        dp = new BigInteger[n+1][s/2+1];
        if(s%2==1) { System.out.println(0); return; }
        System.out.println(dp(n,s/2).multiply(dp(n,s/2)));
    }
    public static BigInteger dp(int n,int s) {
        if(n==0 && s==0) return BigInteger.ONE;
        if(n==0) return BigInteger.ZERO;
        if(s<0) return BigInteger.ZERO;
        if(dp[n][s] != null) return dp[n][s];
        BigInteger ans = BigInteger.ZERO;
        for(int d=0; d<=9; d++)
            ans = ans.add(dp(n-1,s-d));
        return dp[n][s]=ans;
    }
}
