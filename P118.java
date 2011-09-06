import java.util.*;
import java.awt.Point;
import java.math.*;

public class P118 {
    static int[] sums = new int[1000001];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int I = in.nextInt();
        int J = in.nextInt();
        if(I==1) { System.out.println(1); return; }
        for(int i=0; i<sums.length; i++)
            sums[i] = -1;
        
        double min_triv = 100000;
        int min_k = 0;
        for(int i=I; i<=J; i++) {
            double score = triviality(i);
            if(score < min_triv) { min_triv=score; min_k=i; }
        }
        System.out.println(min_k);
    }
    public static double triviality(int n) {
        return ((double)(1+sum_factors(n)))/n;
    }
    public static int sum_factors(int n) {
        if(sums[n] != -1) return sums[n];
        double sqrt = Math.sqrt(n);
        for(int i=2; i<=sqrt; i++)
            if(n%i == 0) return sums[n] = i+(i==(int)(sqrt+0.5)?0:(n/i))+sum_factors(n/i);
        return sums[n]=0;
    }
}
