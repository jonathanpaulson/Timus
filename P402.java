import java.util.*;
import java.awt.Point;
import java.math.*;

public class P402 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger ans = BigInteger.ZERO;
        for(int i=2; i<=n; i++) {
            ans = ans.add(f(n).divide(f(n-i)));
        }
        System.out.println(ans);
    }
    public static BigInteger f(int n) {
        BigInteger ans = BigInteger.ONE;
        for(long i=2; i<=n; i++) {
            ans = ans.multiply(new BigInteger(i+""));
        }
        return ans;
    }
}
