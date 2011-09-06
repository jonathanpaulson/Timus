import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P651 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        int[] last = new int[10001];
        for(int i=0; i<n; i++) {
            data[i] = in.nextInt();
        }
        for(int i=0; i<n; i++) {
            last[data[i]] = i;
            if(data[i] == data[n-1]) break;
        }

        for(int i=0; i<n; i++) {
            System.out.print(data[i]+(data[i]==data[n-1]?"":" "));
            if(data[i] == data[n-1]) break;
            i = last[data[i]];
        }
        System.out.println();
    }
}
