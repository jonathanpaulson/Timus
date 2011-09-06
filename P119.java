import java.util.*;
import java.awt.Point;
import java.math.*;

public class P119 {
    static int n,m;
    static int[] dp = new int[101];
    static Point[] pts;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        int k = in.nextInt();
        pts = new Point[k];
        for(int i=0; i<k; i++)
            pts[i] = new Point(in.nextInt(),in.nextInt());
        int max = 0;
        for(int i=0; i<k; i++)
            if(dp(i)>max)
                max = dp(i);
        System.out.println( (int)((n+m)*100-(200-100*Math.sqrt(2))*max+0.5) );
    }
    public static int dp(int k) {
        int max = 0;
        if(dp[k] > 0) return dp[k];
        for(int i=0; i<pts.length; i++)
            if(pts[i].x > pts[k].x && pts[i].y > pts[k].y)
                max = Math.max(max,dp(i));
        return dp[k]=max+1;
    }
}
