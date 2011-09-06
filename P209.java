import java.util.*;
import java.awt.Point;
import java.math.*;

public class P209 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0; i<n; i++)
            System.out.print( (tri(in.nextLong()-1)?1:0)+(i==n-1?"":" "));
    }
    public static boolean tri(long n) {
        double d = Math.sqrt(1+8*n);
        return Math.abs(d-(int)(d+0.5))<1e-10;
    }
}
