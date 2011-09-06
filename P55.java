import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P55 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        if(m<n/2) m = n-m;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=m+1; i<=n; i++) {
            Map<Integer,Integer> f = p_factor(i);
            map = add(map,f);
        }
        for(int i=2; i<=n-m; i++) {
            Map<Integer,Integer> f = p_factor(i);
            //System.out.println(i+" "+f);
            map = subtract(map,f);
        }
        System.out.println(map.keySet().size());
    }
    public static Map<Integer,Integer> subtract(Map<Integer,Integer> a,Map<Integer,Integer> b) {
        for(Integer i:b.keySet()) {
            if(b.get(i)==a.get(i))
                a.remove(i);
            else a.put(i,a.get(i)-b.get(i));
        }
        return a;
    }
    public static Map<Integer,Integer> add(Map<Integer,Integer> a,Map<Integer,Integer> b) {
        for(Integer i:b.keySet()) {
            a.put(i,b.get(i)+(a.containsKey(i)?a.get(i):0));
        }
        return a;
    }
    static Map<Integer,Integer>[] c = new Map[50001];
    static boolean[] c_s = new boolean[50001];
    public static Map<Integer,Integer> p_factor(int n) {
        if(c_s[n]) return c[n];
        c_s[n]=true;
        if(n==1) return c[n]=new HashMap<Integer,Integer>();
        if(prime(n)) {
            Map<Integer,Integer> ans = new HashMap<Integer,Integer>();
            ans.put(n,1);
            return c[n]=ans;
        }
        for(int p=2; p<=n/2; p++) {
            if(n%p==0 && prime(p)) {
                Map<Integer,Integer> ans = new HashMap<Integer,Integer>(p_factor(n/p));
                ans.put(p,1+(ans.containsKey(p)?ans.get(p):0));
                return c[n]=ans;
            }
        }
        return null; /* Can't happen */
    }
    static boolean[] dp = new boolean[50001];
    static boolean[] dp_s = new boolean[50001];
    public static boolean prime(int n) {
        if(dp_s[n]) return dp[n];
        dp_s[n]=true;
        int lim = (int)sqrt(n);
        for(int i=2; i<=lim; i++)
            if(n%i==0) return dp[n]=false;
        return dp[n]=true;
    }
}
