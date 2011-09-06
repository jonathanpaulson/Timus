import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P453 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int S = in.nextInt();
        int[] C = new int[N];
        for(int i=0; i<N; i++)
            C[i] = in.nextInt()-1;

        BigInteger ans = B(N*(long)(S-1));
        if(N==1) { System.out.println(ans); return; }


        int[] twos = new int[S];
        int zero = S;
        for(int i=0; i<N; i++) {
            zero = min(zero,1+max(C[i],S-1-C[i]));
            twos[1+min(C[i],S-1-C[i])]++;
        }

        BigInteger E = B(2).pow(N);
        for(int i=1; i<zero; i++) {
            E = E.shiftRight(twos[i]);
            ans = ans.add(E);
        }

        System.out.println(ans);
    }

    public static BigInteger B(long n) { return new BigInteger(n+""); }
}
