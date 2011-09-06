import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P150 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String N = in.next();
        long[] ans = new long[10];
        for(int i=0; i<N.length(); i++) {
            for(int j=0; j<N.charAt(i)-'0'; j++) {
                for(int d=0; d<10; d++)
                    ans[d]+=cnt(N.length()-1-i,false);
                for(int k=0; k<i; k++)
                    ans[N.charAt(k)-'0']+=Math.pow(10,N.length()-1-i);
                if(j>0 || i>0) ans[j]+=Math.pow(10,N.length()-1-i);
            }
        }
        for(int i=0; i<N.length(); i++)
            ans[N.charAt(i)-'0']++;
        ans[0]--;
        System.out.println(Arrays.toString(ans));
    }
    public static long cnt(int k,boolean zero) {
        if(k<=0) return 0;
        return 10*cnt(k-1,false)+(long)(zero?0:Math.pow(10,k-1));
    }
}
