import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P10 {
	static double eps = 1e-5;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

		double[] data = new double[N];
		for(int i=0; i<N; i++)
			data[i] = in.nextDouble();

		int ans = 1;
		for(int i=1; i<N; i++)
			if(abs(data[i]-data[i-1]) > abs(data[ans]-data[ans-1]))
				ans = i;
		System.out.println( ans + " " + (ans+1) );
	}
}
