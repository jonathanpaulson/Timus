import java.util.*;
import java.awt.Point;
import java.math.*;

public class P131 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(f(n-1,k,1,0));
    }
    public static int f(int n,int k,int cur,int time) {
        if(n==0) return 0;
        while(cur<k) {
            n-=cur;
            cur*=2;
            time++;
            if(n<=0)
                return time;
        }
        if(n%k==0) return time+n/k;
        return time+n/k+1;
    }
}
