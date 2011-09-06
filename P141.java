import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P141 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        List<Integer> primes = primes(33000);
        for(int t=0; t<k; t++) {
            int e = in.nextInt();
            int n = in.nextInt();
            int c = in.nextInt();
            int i;
            for(i=0; n%primes.get(i)!=0; i++);
            
            int p=primes.get(i);
            int q=n/p;
            BigInteger m = new BigInteger( ((p-1)*(q-1)) +"");
            BigInteger d = new BigInteger(e+"").modInverse(m);
            System.out.println(new BigInteger(c+"").modPow(d,new BigInteger(n+"")));
        }
    }
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
}
