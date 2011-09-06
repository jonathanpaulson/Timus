import java.util.*;
import java.awt.Point;
import java.math.*;

public class P336 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Point> factors = factor(n);

        BigInteger k = BigInteger.ONE;
        BigInteger m = BigInteger.ONE;
        for(Point p:factors) {
            if(p.y%2==1) {
                k = k.multiply(new BigInteger(p.x+""));
                p.y+=3;
            }
            m = m.multiply(new BigInteger(p.x+"").pow(p.y/2));
        }
        System.out.println(m);
        System.out.println(k);
    }
    public static List<Point> factor(int n) {
        for(int i=2; i<=n; i++) {
            if(n%i==0) {
                int cnt = 0;
                while(n%i==0) { cnt++; n/=i; }
                List<Point> factors = factor(n);
                factors.add(new Point(i,cnt));
                return factors;
            }
        }
        return new LinkedList<Point>();
    }
}
