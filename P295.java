import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P295 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        BigInteger ONE = new BigInteger("1");
        BigInteger TWO = new BigInteger("2");
        BigInteger THREE = new BigInteger("3");
        BigInteger FOUR = new BigInteger("4");
        BigInteger TEN = new BigInteger("10");

        BigInteger n = new BigInteger(in.nextLine());
        int cnt = 1;
        BigInteger p = new BigInteger("10");
        while(true) {
            BigInteger x = ONE.modPow(n,p).add(TWO.modPow(n,p)).add(THREE.modPow(n,p)).add(FOUR.modPow(n,p)).mod(p);
            if(!x.equals(BigInteger.ZERO)) {
                System.out.println(cnt-1);
                return;
            }
            cnt++;
            p = p.multiply(TEN);
        }
    }
}
