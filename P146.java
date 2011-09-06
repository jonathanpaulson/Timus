import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P146 {
    static int n;
    static int[][] mat;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ans = Integer.MIN_VALUE;
        n = in.nextInt();
        mat = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++) {
                mat[i][j] = in.nextInt();
                ans = max(ans,mat[i][j]);
            }
        dp  = new int[n][n];
        for(int r=0; r<n; r++) {
            int sum = 0;
            for(int j=0; j<n; j++) {
                sum += mat[r][j];
                dp[r][j] = sum;
            }
        }

        for(int l=0; l<n; l++)
            for(int r=l; r<n; r++) {
                int[] seq = new int[n];
                for(int i=0; i<n; i++)
                    seq[i] = dp[i][r]-(l==0?0:dp[i][l-1]);
                //System.out.println(Arrays.toString(seq));
                int max = 0;
                int sum = 0;
                for(int i=0; i<n; i++) {
                    sum+=seq[i];
                    max = max(max,sum);
                    if(sum<0) sum=0;
                }
                if(max>0) ans = max(ans,max);
            }
        System.out.println(ans);
        
    }
}
