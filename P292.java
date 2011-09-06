import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P292 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int trial = 1; trial <= T; trial++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int L = in.nextInt();
            
            for(int i=1; i<n; i++)
            {
                k = f(k);
                if(k==153) break;
            }
            System.out.println(k-L);
        }
    }
    public static int f(int k)
    {
        int ans = 0;
        while(k>0) {
            int d = k%10;
            ans += d*d*d;
            k/=10;
        }
        return ans;
    }
}
