import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P648 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] data = new int[n];

        long store = 0;
        for(int i=0; i<n; i++) {
            store += d;
            data[i] = min(store >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)store, in.nextInt());
            store -= data[i];
        }

        long cost = 0;
        long num = 0;

        store = 0;
        for(int i=n-1; i>=0; i--) {
            num+=data[i];
            store += data[i];
            store -= d;
            if(store < 0) store = 0;
            cost += store;
        }

        System.out.println(num+" "+cost);
    }
}
