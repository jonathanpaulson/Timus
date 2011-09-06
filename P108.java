import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P108 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		BigInteger mul = new BigInteger("1");
		BigInteger den = new BigInteger("2");
		for(int i=1; i<=n; i++) {
			System.out.println(den);

			mul = mul.multiply(den);
			den = mul.add(BigInteger.ONE);
		}
    }
}
