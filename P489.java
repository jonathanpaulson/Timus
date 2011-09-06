import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P489 {
	static int A;
	static int B;
	static int C;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		A = in.nextInt();
		B = in.nextInt();
		C = in.nextInt();
		List<Double> one = calc(in.nextDouble(),in.nextDouble());
		List<Double> two = calc(in.nextDouble(),in.nextDouble());
		System.out.println(dist(one,two));
    }
	public static double dist(List<Double> a,List<Double> b) {
		double sum = 0;
		for(int i=0; i<a.size(); i++)
			sum += Math.pow(a.get(i)-b.get(i),2);
		return Math.sqrt(sum);
	}
	public static List<Double> calc(double x,double y) {
		double X,Y,Z;
		if(x<C) {
			X = C;
			Y = y;
			Z = C-x;
		}
		else if(x>C+A) {
			X = C+A;
			Y = y;
			Z = x-C-A;
		}
		else if(y<B) {
			X = x;
			Y = B-y+B+C;
			Z = C;
		}
		else if(y<B+C) {
			X = x;
			Y = B+C;
			Z = B+C-y;
		}
		else if(y<B+C+B) {
			X = x;
			Y = y;
			Z = 0;
		}
		else {
			X = x;
			Y = B+C+B;
			Z = y-B-C-B;
		}
		List<Double> ret = new ArrayList<Double>();
			ret.add(X);
			ret.add(Y);
			ret.add(Z);
		return ret;
	}
}
