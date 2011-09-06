import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P142 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] dp = new int[11][11];
        dp[1][1] = 1;
        for(int n=2; n<=10; n++) {
            for(int k=1; k<=n; k++) {
                dp[n][k] = k*dp[n-1][k]+k*dp[n-1][k-1];
            }
            //System.out.println(Arrays.toString(dp[n]));
        }

        int[] sums = new int[11];
        for(int i=2; i<=10; i++) {
            int sum = 0;
            for(int j=1; j<=i; j++)
                sum += dp[i][j];
            sums[i] = sum;
        }

        while(true) {
            int n = in.nextInt();
            if(n==-1) return;
            System.out.println(sums[n]);
        }
    }
}
