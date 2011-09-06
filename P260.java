import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P260 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n<=2) { System.out.println(1); return; }
        System.out.println(SHLS(n)+SHL(n)+SLH(n)+SH(n));
    }

    static int[] SHLS_dp = new int[100];
    public static int SHLS(int n) {
        if(n==3) return 0;
        if(SHLS_dp[n] > 0) return SHLS_dp[n];
        return SHLS_dp[n] = SHL(n-1)+SHLS(n-1);
    }
    public static int SHL(int n) {
        if(n==3) return 1;
        return SLH(n-1);
    }
    static int[] SLH_dp = new int[100];
    public static int SLH(int n) {
        if(n==3) return 1;
        if(SLH_dp[n] > 0) return SLH_dp[n];
        return SLH_dp[n] = SLH(n-1)+SH(n-1);
    }
    public static int SH(int n) {
        if(n==3) return 0;
        return SHL(n-1);
    }

}
