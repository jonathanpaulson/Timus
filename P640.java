import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P640 {
	static Point[] pts;
	static int X = 1100;
	static int Y = 1100;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		pts = new Point[n];
		double max = 0;
		for(int i=0; i<n; i++) {
			max = Math.max(distance(in.nextInt(),in.nextInt()),max);
		}
		System.out.println(X+" "+Y+" "+Math.sqrt(max));
    }
	public static double distance(int x,int y) {
		return (x-X)*(x-X)+(y-Y)*(y-Y);
	}
}
