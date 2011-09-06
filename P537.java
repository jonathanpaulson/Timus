import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P537 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int p = in.nextInt();
        for(int i=2; i<k; i++)
            f(i,p);
        System.out.println(f(k,p));
    }
    public static int[] dp = new int[10000001];
    public static int f(int k,int p) {
        if(k<2) return 0;
        if(k==2) return 1%p;
        if(dp[k] > 0) return dp[k];
        return dp[k] = (f(k-1,p)+(k%2==0?f(k/2,p):0))%p;
    }
}
