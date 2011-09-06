import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P330 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine().trim());
        int[] sums = new int[n+1];
        for(int i=1; i<=n; i++)
            sums[i] = sums[i-1]+Integer.parseInt(in.readLine().trim());
        int Q = Integer.parseInt(in.readLine().trim());
        for(int i=0; i<Q; i++) {
            StringTokenizer arr = new StringTokenizer(in.readLine().trim());
            int start = Integer.parseInt(arr.nextToken());
            int end = Integer.parseInt(arr.nextToken());
            System.out.println(sums[end]-sums[start-1]);
        }
    }
}
