import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P641 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int m = in.nextInt();

		for(int i=0; i<n; i++)
			System.out.println((i%k)+1);
		
		Set<Point> used = new HashSet<Point>();
		int count=0;
		for(int i=1; i<n; i+=2) {
			System.out.println(i+" "+(i+1));
			used.add(new Point(i,i+1));
			count++;
		}
		if(n%2==1) {
			System.out.println(n+" "+(n-1));
			used.add(new Point(n,n-1));
			count++;
		}
		for(int c1=0; c1<k; c1++)
			for(int c2=c1+1; c2<k; c2++)
				for(int i=c1; i<n; i+=k)
					for(int j=c2; j<n; j+=k) {
						if(count < m && !used.contains(new Point(i+1,j+1)) && !used.contains(new Point(j+1,i+1))) {
							System.out.println((i+1)+" "+(j+1));
							count++;
						}
					}
    }
}
