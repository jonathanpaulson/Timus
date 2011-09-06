import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P351 {
    static double EPS=1e-9;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d = in.nextInt();
        int x = in.nextInt(); int y = in.nextInt();
    
        double t1 = atan2(y,x);
        x = in.nextInt(); y = in.nextInt();
        double t2 = atan2(y,x);
        
        //System.out.println(t1+" "+t2+" "+d);
        int n = in.nextInt();
        for(int i=0; i<n; i++) {
            x = in.nextInt(); y = in.nextInt();
            double angle = atan2(y,x);
            double dist = x*x+y*y;
            System.out.println(angle+" "+dist);
            System.out.println(less(t2,angle));
            System.out.println(less(angle,t1));
            if(dist < d*d+EPS && between(t1,t2,angle))
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
    public static boolean between(double t1,double t2,double angle) {
        return (less(t1,angle) && less(angle,t2))
            || (less(t2,angle) && less(angle,t1));
    }
    public static boolean less(double a,double b) {
        if(a<0) return a<b+EPS && b<a+PI+EPS;
        return a<b+EPS || b < a-PI+EPS;
    }
}
