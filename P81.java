import java.util.*;
import java.awt.Point;
import java.math.*;

public class P81 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long k = in.nextLong();
        if(k > fib(n+2)) { System.out.println(-1); return; }
        System.out.println(f(n,k));
    }
    public static String f(int n,long k) {
		if(n==1) return k==1?"0":"1";
        if(n==2) return k==1?"00": k==2? "01" : "10";
        if(k > fib(n+1)) return "10"+f(n-2,k-fib(n+1));
        return "0"+f(n-1,k);
    }
    
    static long[] dp = new long[100];
    public static long fib(int n)
    {
        if(n <=2) return 1;
        if(dp[n] > 0) return dp[n];
        return dp[n] = fib(n-1)+fib(n-2);
    }
}
