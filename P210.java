import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P210 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] costs = new int[31];
		for(int i=0; i<31; i++) costs[i] = Integer.MAX_VALUE;
		costs[1] = 0;
		for(int i=1; i<=n; i++) {
			int k = in.nextInt();
			int[] tmp = new int[31];
			for(int j=0; j<31; j++) tmp[j]=Integer.MAX_VALUE;
			for(int j=1; j<=k; j++) {
				while(true) {
					int from = in.nextInt();
					if(from == 0) break;
					int cost = in.nextInt();
					tmp[j]=Math.min(costs[from]+cost,tmp[j]);
				}
			}
			costs = tmp;
			if(i<n) in.next();
		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i<31; i++)
			min = Math.min(costs[i],min);
		System.out.println(min);
    }
}
