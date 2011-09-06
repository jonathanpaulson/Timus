import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P788 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int G[] = new int[n];
		for(int i=0; i<n; i++)
			G[i] = in.nextInt();
		int B[] = new int[m];
		for(int i=0; i<m; i++)
			B[i] = in.nextInt();
		Arrays.sort(G);
		Arrays.sort(B);
		int min = 1000000;
		for(int k=0; k<=min(n,m); k++) {
			int cost = 0;
			for(int i=0; i<n-k; i++)
				cost += G[i];
			for(int i=0; i<m-k; i++)
				cost += k*B[i];
			min = min(cost,min);
		}
		System.out.println(min);
    }
}
