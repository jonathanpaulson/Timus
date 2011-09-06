import java.util.*;
import java.awt.Point;
import java.math.*;

public class P222 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //for(int i=1; i<=20; i++)
         //   System.out.println(i+" "+f(i));
        System.out.println(f(in.nextInt()));
    }
    public static BigInteger f(int n) {
        BigInteger prod = BigInteger.ONE;
        BigInteger two = new BigInteger(2+"");
        BigInteger three = new BigInteger(3+"");
        if(n==1) return prod;
        while(n%3!=0) {
            prod = prod.multiply(two);
            n-=2;
        }
        while(n>0) { 
            prod = prod.multiply(three);
            n-=3;
        }
        return prod;
    }
}
