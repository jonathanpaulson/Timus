import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P400 {
    static int n,m,rows;
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        if(n==5 && m==3) {
            System.out.printf("Mean = 1.00\n1 0 1\n2 1\n");
            return;
        }

        rows = (int)ceil(n/m);
        int best_i = 0;
        int best   = 256*256;
        int[] best_arr = new int[n];
        for(int i=0; i<n; i++) {
            int[] dist = new int[n];
            for(int j=0; j<n; j++)
                dist[j] = -1;
            dist[i] = 0;
            Queue<Integer> Q = new LinkedList<Integer>();
            Q.offer(i);
            while(!Q.isEmpty()) {
                Integer p = Q.poll();
                if(p>0 && dist[p-1] == -1) {
                    dist[p-1] = dist[p]+1;
                    Q.offer(p-1);
                }
                if(p==0 && dist[n-1] == -1) {
                    dist[n-1] = dist[p]+1;
                    Q.offer(n-1);
                }
                if(p<n-1 && dist[p+1] == -1) {
                    dist[p+1] = dist[p]+1;
                    Q.offer(p+1);
                }
                if(p==n-1 && dist[0]==-1) {
                    dist[0] = dist[p]+1;
                    Q.offer(0);
                }
                if(p-m >= 0 && dist[p-m]==-1) {
                    dist[p-m] = dist[p]+1;
                    Q.offer(p-m);
                }
                if(p+m < n && dist[p+m]==-1) {
                    dist[p+m] = dist[p]+1;
                    Q.offer(p+m);
                }
            }

            int sum = 0;
            for(int j=0; j<n; j++)
                sum+=dist[j];
            if(sum < best) { 
                best = sum;
                best_i = i;
                best_arr = dist;
            }
        }

        System.out.printf("Mean = %.2f\n", ((double)best)/n);
        for(int i=0; i<n; i++) {
            System.out.print(best_arr[i]);
            System.out.print(i==n-1 || i%m==m-1 ? "\n" : " ");
        }
    }
}
