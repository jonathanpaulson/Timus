import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P480 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] ans = new int[n][n];
        int hi = n*n;
        int lo = 1;
        for(int d=0; d<2*n-1; d++) {
            for(int x=0; x<=d; x++) {
                if(x < n && d-x < n)
                    ans[x][d-x] = (d%2 == 0 ? hi-- : lo++);
            }
        }
        if(n == 1) System.out.println(1);
        else System.out.println(n*n+n/2+1);
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                System.out.print(ans[i][j]+(j==n-1?"\n":" "));
    }
}
