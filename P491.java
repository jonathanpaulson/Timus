import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P491 {
    static int[] min;
    static int[] max;
    static int[] cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        min = new int[4*n];
        max = new int[4*n];
        cnt = new int[4*n];
        populate(1,n,1);

        Set<Integer> K = new HashSet<Integer>();
        String[] arr = in.readLine().split(" ");
        int K_a = Integer.parseInt(arr[0]);
        int K_b = Integer.parseInt(arr[1]);
        int K_c = Integer.parseInt(arr[2]);
        add(K_a,K_b,K_c,1);
        for(int i=0; i<n; i++) {
            arr = in.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            add(a,b,c,1);
        }

        for(int i=1; i<=n; i++) {
            System.out.print( (get(i,1)+(K.contains(i)?K_c:0)) +(i==n?"":" "));
        }
        System.out.println();
    }
    public static void populate(int lo,int hi,int node)
    {
        min[node] = lo;
        max[node] = hi;
        if(lo != hi) {
            populate(lo,lo+(hi-lo)/2,node*2);
            populate(1+lo+(hi-lo)/2,hi,node*2+1);
        }
    }

    public static void add(int a,int b,int c,int node)
    {
        int hi_left = min[node]+(max[node]-min[node])/2;
        if(min[node]==a && max[node]==b) { cnt[node]+=c; return; }
        if(a <= hi_left) add(a,min(b,hi_left),c,node*2);
        if(b > hi_left) add(max(a,1+hi_left),b,c,node*2+1);
    }

    public static int get(int n,int node)
    {
        int hi_left = min[node]+(max[node]-min[node])/2;
        if(min[node] == max[node]) return cnt[node];
        return cnt[node]+(n<=hi_left ? get(n,node*2) : get(n,node*2+1));
    }
}
