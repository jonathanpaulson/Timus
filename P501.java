import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P501 {
    static int n;
    static String s1;
    static String s2;
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); in.nextLine();
        s1 = in.nextLine();
        s2 = in.nextLine();
        dp = new String[n+1][n+1][3];
        String ans = dp(0,0,0);
        System.out.println(ans == null ? "Impossible" : ans);
    }

    static String[][][] dp;
    public static String dp(int i1,int i2,int state)
    {
        if(dp[i1][i2][state] != null) return dp[i1][i2][state];
        if(i1==n && i2==n) return "";
        if(state == 0) {
            if(i1 < n) {
                String t1 = dp(i1+1,i2,s1.charAt(i1)=='0'?1:2);
                if(t1 != null) return dp[i1][i2][state] = 1+t1;
            }
            if(i2 < n) {
                String t2 = dp(i1,i2+1,s2.charAt(i2)=='0'?1:2);
                if(t2 != null) return dp[i1][i2][state] = 2+t2;
            }
        }
        if(state == 1) {
            if(i1 < n && s1.charAt(i1)=='1') {
                String t1 = dp(i1+1,i2,0);
                if(t1 != null) return dp[i1][i2][state] = 1+t1;
            }
            if(i2 < n && s2.charAt(i2)=='1') {
                String t2 = dp(i1,i2+1,0);
                if(t2 != null) return dp[i1][i2][state] = 2+t2;
            }
        }
        if(state == 2) {
            if(i1 < n && s1.charAt(i1)=='0') {
                String t1 = dp(i1+1,i2,0);
                if(t1 != null) return dp[i1][i2][state] = 1+t1;
            }
            if(i2 < n && s2.charAt(i2)=='0') {
                String t2 = dp(i1,i2+1,0);
                if(t2 != null) return dp[i1][i2][state] = 2+t2;
            }
        }
        return null;
    }
}
