import java.util.*;
import java.awt.Point;
import java.math.*;

public class P24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] perm = new int[n];
        for(int i=0; i<n; i++)
            perm[i] = in.nextInt()-1;
        boolean[] seen = new boolean[n];
        int ans = 1;
        for(int index=0; index<n; index++) {
            while(index<n && seen[index]) index++;
            if(index==n) break;
            int size = 1;
            int cur = index;
            while(perm[cur] != index) {
                seen[cur] = true;
                cur = perm[cur];
                size++;
            }
            ans = lcm(ans,size);
        }
        System.out.println(ans); 
    }
    public static int lcm(int x,int y) { return x/gcd(x,y)*y; }
    public static int gcd(int x,int y) {
        if(y==0) return x;
        return gcd(y,x%y);
    }
}
