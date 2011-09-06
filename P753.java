import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P753 {
	static double h;
	static double H;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		h = in.nextDouble();
		H = in.nextDouble();
		double L = in.nextDouble();
		
		double min = 0;
		double max = L;
		while(max - min > 1e-7) {
			double g = min+(max-min)/3;
			double h = min+2*(max-min)/3;
			if(f(g) > f(h))
				max = h;
			else min = g;
		}
		double ans = (max+min)/2;
		System.out.printf("%.6f\n",f(ans));
	}
	public static double f(double x) {
		double theta = atan(h/x);
		return (H*cos(theta)-2*x)/2;
	}
}
