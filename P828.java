import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P828 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double[] x = new double[n+1];
        double[] y = new double[n+1];
        double xs = 0;
        double ys = 0;
        for(int i=1; i<=n; i++) {
            x[i] = i;
            y[i] = in.nextInt();
            xs += x[i];
            ys += y[i];
        }
        xs/=n;
        ys/=n;

        double hi = 0;
        for(int i=1; i<=n; i++)
            hi += (x[i]-xs)*(y[i]-ys);
        double lo = 0;
        for(int i=1; i<=n; i++)
            lo+=(x[i]-xs)*(x[i]-xs);

        double m = hi/lo;
        double b = ys-m*xs;

        System.out.println( (b+m)+" "+m );

    }
}
