import java.util.*;
import java.awt.Point;
import java.math.*;

public class P582 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        double mean = 1/(1/a+1/b+1/c);
        System.out.println( (int)(mean*1000+0.5) );
    }
}
