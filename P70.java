import java.util.*;
import java.awt.Point;
import java.math.*;

public class P70 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a1 = in.nextDouble();
        double a2 = in.nextDouble();
        double t1 = a2-a1;
        if(Math.abs(t1)>12)
            t1+=24;

        double b1 = in.nextDouble();
        double b2 = in.nextDouble();
        double t2 = b2-b1;
        if(Math.abs(t2)>12)
            t2+=24;

        int ans = (int)(0.5+Math.abs(t2-t1)/2);
        System.out.println(ans<=5?ans:24-ans);
    }
}
