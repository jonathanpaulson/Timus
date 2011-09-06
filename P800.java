import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P800 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        double L = in.nextDouble();
        double H = in.nextDouble();
        double W = in.nextDouble();

        if(L/2 > H) { System.out.println("butter"); return; }
        double T = sqrt(2*(H-L/2)/981);
        double angle = (W*2*PI*T/60)%(2*PI);
        if(angle <= PI/2 || angle>=3*PI/2) System.out.println("butter");
        else System.out.println("bread");
    }
    public static double d(double t) {
        return 0.5*9.81*100*t*t;
    }
}
