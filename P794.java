import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P794 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] cnts = new int[n];
        for(int i=0; i<n; i++) {
            int val = in.nextInt()-1;
            cnts[(i+n-val)%n]++;
        }

        int max = 0;
        for(int i=0; i<n; i++)
            if(cnts[i] > cnts[max]) max = i;

        System.out.println(max+1);
    }
}
