import java.util.*;
import java.awt.Point;
import java.math.*;

public class P167 {
    static boolean arr[];
    static int[][] dp;
    static int[][] costs;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr = new boolean[n];
        int k = in.nextInt();
        dp = new int[n+1][k+1];
        costs = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                costs[i][j] = -1;
        for(int i=0; i<n+1; i++)
            for(int j=0; j<k+1; j++)
                dp[i][j] = -1;
        for(int i=0; i<n; i++)
            arr[i] = in.nextInt()==1;
        System.out.println(dp(0,k));
    }
    public static int dp(int n,int k) {
        if(k==1) return cost(n,arr.length-1);
        if(n==arr.length-1) return 0;
        if(dp[n][k] != -1) return dp[n][k];
        int min_cost = Integer.MAX_VALUE;
        for(int i=n+1; i<arr.length; i++) {
            int cost = cost(n,i-1)+dp(i,k-1);
        //    System.out.println(n+" "+i+" "+cost);
            min_cost = Math.min(min_cost,cost);
        }
        return dp[n][k] = min_cost;
    }
    public static int cost(int start,int end) {
        if(costs[start][end] != -1) return costs[start][end];
        int c1 = 0;
        int c2 = 0; 
        for(int i=start; i<=end; i++)
            if(arr[i]) c1++;
            else c2++;
        return costs[start][end] = c1*c2;
    }
}
