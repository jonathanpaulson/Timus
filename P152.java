import java.util.*;
import java.awt.Point;
import java.math.*;

public class P152 {
    static int n;
    static int[] data;
    static int[] dp = new int[1<<20];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        data = new int[n];
        for(int i=0; i<1<<20; i++)
            dp[i] = -1;
        for(int i=0; i<n; i++)
            data[i] = in.nextInt();
        System.out.println(dp(0));
    }
    public static int dp(int code) {
        int min = Integer.MAX_VALUE;
        if( (code+1>>n) > 0) return 0;
        if(dp[code] > -1) return dp[code];
        for(int i=0; i<n; i++) {
            int scratch = code;
            scratch|=1<<i;
            scratch|=1<<((i+n-1)%n);
            scratch|=1<<((i+1)%n);
            if(scratch == code) continue;
            min = Math.min(min,sum(scratch)+dp(scratch));
        }
        return dp[code]=min;
    }
    public static int sum(int code) {
        int sum = 0;
        for(int i=0; i<n; i++)
            if(((code>>i)&1)==0)
                sum+=data[i];
        return sum;
    }
}
