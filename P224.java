import java.util.*;
import java.awt.Point;
import java.math.*;

public class P224 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();
        System.out.println( (Math.min(n,m)-1)*2+(n>m?1:0) );
    }
}
