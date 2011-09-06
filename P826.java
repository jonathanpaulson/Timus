import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P826 {
    static int[] data;
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        data = new int[n];
        for(int i=0; i<n; i++)
            data[i] = in.nextInt();
        Arrays.sort(data);
        System.out.println(cost(n-1));
    }
    static int[] dp = new int[101];
    public static int cost(int n)
    {
        if(n==0) return data[0];
        if(n==1) return data[1];
        if(n==2) return data[2]+data[0]+data[1];
        if(dp[n] > 0) return dp[n];
        return dp[n] = min(data[1]+data[0]+data[n]+data[1]+cost(n-2),
                   data[n]+data[0]+cost(n-1));
    }
}
