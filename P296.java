import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P296 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long sum = 0;
        long max = 0;
        int N = in.nextInt();
        for(int i=0; i<N; i++) {
            sum += in.nextInt();
            if(sum<0) sum=0;
            max = max(max,sum);
        } 
        System.out.println(max);
    }
}
