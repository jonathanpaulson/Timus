import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P783 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] data = new int[n+m-1];
        for(int i=0; i<n+m-1; i++)
            data[i] = in.nextInt();
        int cur = 0;
        for(int i=0; i<n; i++) {
            int ans = -100000;
            for(int j=1; j<=m; j++)
                ans = max(ans, (int)ceil( (data[i+j-1]-cur)/((double)j) ));
            System.out.print(ans+(i==n-1?"\n":" "));
            cur += ans;
        }
    }
}
