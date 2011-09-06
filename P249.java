import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P249 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = in.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        if(n<=1 || m<=1) { System.out.println("Yes"); return; }
        
        int cnt = 1;
        int[] line = new int[m];
        int[] prev = new int[m];
        arr = in.readLine().split(" ");
        for(int i=0; i<m; i++)
            line[i] = Integer.parseInt(arr[i]);

        do {
            for(int i=0; i<m; i++)
                prev[i] = line[i];
            arr = in.readLine().split(" ");
            for(int i=0; i<m; i++)
                line[i] = Integer.parseInt(arr[i]);
            cnt++;
            for(int i=0; i<m-1; i++) {
                if( (prev[i] == 0 && prev[i+1] == 1 && line[i] == 1 && line[i+1] == 1) ||
                    (prev[i] == 1 && prev[i+1] == 0 && line[i] == 1 && line[i+1] == 1) ||
                    (prev[i] == 1 && prev[i+1] == 1 && line[i] == 0 && line[i+1] == 1) ||
                    (prev[i] == 1 && prev[i+1] == 1 && line[i] == 1 && line[i+1] == 0))
                {
                    System.out.println("No"); return;
                }

            }
        } while(cnt < n);
        System.out.println("Yes");
    }
    public static void getline(Scanner in, int m,int[] a) {
        for(int i=0; i<m; i++)
            a[i] = in.nextInt();
    }
}
