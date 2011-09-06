import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P204 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long L=1000000000L;
        List<Integer> primes = primes((int)(sqrt(L)));
        int k = in.nextInt();
        for(int t=0; t<k; t++) {
            int n = in.nextInt();
            int i=0;
            for(i=0; n%primes.get(i)!=0; i++);
            int p1 = primes.get(i);
            int p2 = n/p1;

            BigInteger P1 = new BigInteger(p1+"");
            BigInteger P2 = new BigInteger(p2+"");
            int p1_inv = P1.modInverse(P2).intValue();
            int p2_inv = P2.modInverse(P1).intValue();

            int a1 = p1*p1_inv;
            int a2 = p2*p2_inv;
            System.out.print("0 1 ");
            if(a1<a2) System.out.print(a1+" "+a2);
            else System.out.print(a2+" "+a1);
            System.out.println();
        }
    }
    /* Sieve of Eratosthenes */
    public static List<Integer> primes(int n) {
        boolean[] composite = new boolean[n+1];
        for(int i=2; i<=n; i++) {
            if(composite[i]) continue;
            for(int j=i+i; j<=n; j+=i)
                composite[j]=true;
        }
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=2; i<=n; i++)
            if(!composite[i]) ans.add(i);
        return ans;
    }
    public static boolean prime(long n) {
        int lim = (int)sqrt(n);
        for(int i=2; i<=lim; i++)
            if(n%i==0) return false;
        return true;
    }
    public static int gcd(int x,int y) {
        if(y==0) return x;
        return gcd(y,x%y);
    }
    public static StringBuffer next(StringBuffer str) {
        int k = -1;
        for(int i=0; i<str.length()-1; i++)
            if(str.charAt(i) < str.charAt(i+1)) k=i;
        if(k==-1) return null;
        int l=k+1;
        for(int i=k+1; i<str.length(); i++)
            if(str.charAt(k) < str.charAt(i)) l=i;
        
        swap(str,k,l);
        for(int i=k+1; str.length()-1+(k+1-i) > i; i++) {
            swap(str,i,str.length()-1+(k+1-i));
        }
        return str;
    }
    public static void swap(StringBuffer str,int a,int b) {
        char c = str.charAt(a);
        str.setCharAt(a,str.charAt(b));
        str.setCharAt(b,c);
    }
}
