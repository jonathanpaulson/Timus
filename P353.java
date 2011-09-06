import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P353 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int S = in.nextInt();
        System.out.println(dp(9,S)+(S==1?1:0));
    }
    static boolean[][] dp_s = new boolean[10][82];
    static long[][] dp = new long[10][82];
    public static long dp(int n,int s) {
        if(dp_s[n][s]) return dp[n][s];
        dp_s[n][s]=true;
        if(n==0 && s==0) return dp[n][s]=1;
        if(n==0) return dp[n][s]=0;
        long ans = 0;
        for(int d=0; d<10 && d<=s; d++) {
            ans+=dp(n-1,s-d);
        }
        return dp[n][s]=ans;
    }
}
