import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;
import java.awt.geom.*;

public class P348 {
	static double R;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		double L1X = in.nextInt();
		double L1Y = in.nextInt();
		double L2X = in.nextInt();
		double L2Y = in.nextInt();
		double PX = in.nextInt();
		double PY = in.nextInt();
		R = in.nextInt();

		System.out.println(convert(Line2D.ptSegDist(L1X,L1Y,L2X,L2Y,PX,PY)));
		System.out.println(convert(Math.max(Point2D.distance(PX,PY,L1X,L1Y),Point2D.distance(PX,PY,L2X,L2Y))));
    }
	public static double convert(double r) {
		return Math.max(0,r-R);
	}
}
