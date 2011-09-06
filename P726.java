import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P726 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(in.readLine());
        double[] x = new double[(int)n];
        double[] y = new double[(int)n];
        for(int i=0; i<n; i++) {
            String[] arr = in.readLine().split(" ");
            x[i] = Integer.parseInt(arr[0]);
            y[i] = Integer.parseInt(arr[1]);
        }
        Arrays.sort(x);
        Arrays.sort(y);
        long sum = 0;
        for(int i=0; i<n; i++) {
            sum+= x[i]*(-(n-1)+2*i) + y[i]*(-(n-1)+2*i);
        }
        System.out.println(sum/(n*(n-1)/2));
    }
}
