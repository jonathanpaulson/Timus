import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P47 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double a0 = in.nextDouble();
        double aL = in.nextDouble();
        double S = 0;
        for(int i=0; i<n; i++)
            S += 2*(n-i)*in.nextDouble();

        double d0 = (aL-a0-S)/(n+1.0);
        System.out.printf("%.2f\n",a0+d0);
    }
}
