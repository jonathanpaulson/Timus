import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P306 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] data = new int[n];
        for(int i=0; i<n; i++)
            data[i] = Integer.parseInt(in.readLine());
        Arrays.sort(data);
        if(n%2==1) System.out.printf("%.1f\n",data[n/2]);
        else System.out.printf("%.1f\n",(data[n/2]+data[n/2-1])/2.0);
    }
}
