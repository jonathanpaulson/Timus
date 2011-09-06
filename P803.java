import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P803 {
    static int[] c;
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        BigInteger[] f = new BigInteger[n+1];
        f[1] = B(1);
        f[2] = B(1);
        for(int i=3; i<=n; i++)
            f[i] = f[i-1].add(f[i-2]);
        c = new int[n+1];
        for(int i=1; i<=n; i++) {
            String s = f[i].toString(k);
            int cnt = 0;
            for(int j=0; j<s.length(); j++)
                cnt += s.charAt(j)-'0';
            c[i] = cnt;
        }

        Integer[] L = new Integer[n];
        for(int i=0; i<n; i++)
            L[i] = i+1;
        Arrays.sort(L,new CI());

        for(int i=0; i<n; i++)
            System.out.print(L[i]+(i==n-1?"\n":" "));
    }

    private static class CI implements Comparator<Integer> {
        public int compare(Integer a,Integer b) {
            return c[a]-c[b];
        }
    }

    public static BigInteger B(int n) { return new BigInteger(n+""); }
}
