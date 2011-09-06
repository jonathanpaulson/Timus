import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P192 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double my_PI = 3.1415926535;
        double V = in.nextDouble();
        double A = in.nextDouble()*my_PI/180;
        double K = in.nextDouble();
        double g = 10;

        System.out.printf("%.2f\n",2*sin(A)*V/g * V*cos(A) * K/(K-1));
    }
}
