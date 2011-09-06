import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P91 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        int S = in.nextInt();
        int ans = 0;
        for(int F=2; F<=S; F++) {
            if(!prime(F)) continue;
            int n = S/F;
            ans += choose(n,K);
            if(ans>10000) break;
        }
        System.out.println(ans>10000?10000:ans);
    }
    public static boolean prime(int n) {
        for(int i=2; i<=Math.sqrt(n); i++)
            if(n%i==0) return false;
        return true;
    }
    public static int choose(int n,int k) {
        if(n<k) return 0;
        if(k<n/2) return choose(n,n-k);
        long ans=1;
        for(int i=k+1; i<=n; i++)
            ans*=i;
        for(int i=2; i<=n-k; i++)
            ans/=i;
        return (int)ans;
    }
    public static long f(int n) {
        long ans = 1;
        for(long i=2; i<=n; i++)
            ans*=i;
        return ans;
    }
}
