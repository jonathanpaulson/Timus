import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P114 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int A = in.nextInt();
        int B = in.nextInt();
        System.out.println(C(N+A,A).multiply(C(N+B,B)));
    }
    public static BigInteger C(int n,int k) {
        if(k<n/2) return C(n,n-k);
        BigInteger ans = BigInteger.ONE;
        for(int i=k+1; i<=n; i++)
            ans=ans.multiply(new BigInteger(i+""));
        for(int i=2; i<=n-k; i++)
            ans=ans.divide(new BigInteger(i+""));
        return ans;
    }
}
