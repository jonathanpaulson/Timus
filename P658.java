import java.util.*;
import java.awt.Point;
import java.math.*;

public class P658 {
    static int[][] dp = new int[901][8101];
    static boolean[][] seen = new boolean[901][8101];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int i=0; i<dp.length; i++)
            for(int j=0; j<dp[i].length; j++)
                dp[i][j] = -1;
        for(int i=0; i<dp.length; i++)
            for(int j=0; j<dp[i].length; j++)
                dp(i,j,100);
        int n = in.nextInt();
        OUTER: for(int i=0; i<n; i++) {
            int S1 = in.nextInt();
            int S2 = in.nextInt();
            if(S1 > 900 || S2>8100 || dp[S1][S2] > 100 || dp[S1][S2] < 0)
                { System.out.println("No solution"); continue OUTER; }
            String ans = "";
            while(S1 > 0) {
                int min = dp[S1][S2];
                int min_i = 10000;
                for(int d=1; d<=9; d++) {
                    if(S1-d >=0 && S2-d*d>=0 && dp[S1-d][S2-d*d] < min && dp[S1-d][S2-d*d]!=-1) {
                        min = dp[S1-d][S2-d*d];
                        min_i = d;
                    }
                }
                ans+=min_i;
                S1-=min_i;
                S2-=min_i*min_i;
            }
            System.out.println(ans);
        }
    }
    public static int dp(int S1,int S2,int depth) {
        if(depth < 0) return 1000;
        if(S1 > 900 || S2>8100) return 1000;
        if(S1 < 0 || S2 < 0) return 1000;
        if(S1 == 0 && S2 == 0) return dp[S1][S2]=0;
        if(S1 == 0) return dp[S1][S2]=1000;
        if(S2 == 0) return dp[S1][S2]=1000;
        if(dp[S1][S2] > -1) {
            if(dp[S1][S2] <= depth) return dp[S1][S2];
            return 1000;
        }

        int min = 1000;
        for(int d=1; d<=9; d++) {
            int score = dp(S1-d,S2-d*d,depth-1);
            if(score < min && score < depth)
                min = score;
        }
        return dp[S1][S2] = min+1;
    }
}
