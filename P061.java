import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P61 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long INFTY = 1000000000L;
        int n = in.nextInt();
        int k = in.nextInt();
        long[] arr = new long[n];
        String s = "";
        while(in.hasNext()) s+=in.next();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='*') arr[i]=INFTY;
            else arr[i]=s.charAt(i)-'0';
        }
        long[] sums = new long[n];
        sums[0] = arr[0];
        for(int i=1; i<arr.length; i++)
            sums[i]=sums[i-1]+arr[i];
        
        long min_score = INFTY;
        int min_l = -1;
        for(int i=0; i+k-1<arr.length; i++) {
            long score = sums[i+k-1]-(i==0?0:sums[i-1]);
            if(score < min_score) {
                min_score = score;
                min_l = i;
            }
        }
        System.out.println(min_l+1);
    }
}
