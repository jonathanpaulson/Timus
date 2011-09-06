import java.util.*;
import java.awt.Point;
import static java.lang.Math.*;
import java.math.*;

public class P84 {
    private static double EPS=1e-9;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double S = in.nextInt();
        double R = in.nextInt();
        double area = 0;
        if(2*R < S+EPS)
            area = PI*R*R;
        else if(2*R > S*sqrt(2)-EPS)
            area = S*S;
        else {
            double a = sqrt(R*R-(S/2)*(S/2));
            double area_tri = a*(S/2)/2;

            double alpha = acos( (S/2)/R );
            double theta = PI/4-alpha;
            double area_sec = R*R*theta/2;

            area = (area_tri+area_sec)*8;
        }
        System.out.printf("%.03f\n",(area+EPS));
    }
}
