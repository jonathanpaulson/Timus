import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P184 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        long sum = 0;
        List<Integer> L = new ArrayList<Integer>();
        for(int i=0; i<n; i++) {
            L.add((int)(in.nextDouble()*100));
            sum+=L.get(i);
        }

        long lo = 1;
        long hi = sum;
        while(lo < hi)
        {
            long guess = lo+(hi-lo+1)/2;
            int cnt = 0;
            for(Integer x:L)
                cnt += x/guess;
            if(cnt >= k) lo = guess;
            else hi=guess-1;
        }
        int cnt = 0;
        for(Integer x:L)
            cnt += x/lo;
        if(cnt >= k) System.out.printf("%.2f\n",lo/100.0);
        else System.out.println("0.00");

    }
}
