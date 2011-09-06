import java.util.*;
import java.awt.Point;
import java.math.*;

public class P139 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt()-1;
        int m = in.nextInt()-1;
        System.out.println( n+m-gcd(n,m));
    }
    public static int gcd(int x,int y) {
        if(y==0) return x;
        return gcd(y,x%y);
    }
}
