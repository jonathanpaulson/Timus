import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P272 {
    static int[] uf;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        uf = new int[n];
        for(int i=0; i<n; i++) uf[i]=i;
        int k = in.nextInt();
        int m = in.nextInt();
        for(int i=0; i<k; i++)
            mix(in.nextInt()-1,in.nextInt()-1);
        int ans = 0;
        for(int j=0; j<m; j++) {
            int start = in.nextInt()-1;
            int end = in.nextInt()-1;
            if(find(start)!=find(end)) { mix(start,end); ans++; }
        }
        System.out.println(ans);
    }
    public static int find(int x) {
        if(uf[x]==x) return x;
        return uf[x]=find(uf[x]);
    }
    public static void mix(int a,int b) {
        uf[find(a)] = find(b);
    }
}
