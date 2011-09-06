import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P15 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Map<Long,List<Integer>> map = new HashMap<Long,List<Integer>>();
		List<Long> order = new ArrayList<Long>();
		for(int i=1; i<=n; i++) {
			int L = in.nextInt();
			int R = in.nextInt();
			int T = in.nextInt();
			int F = in.nextInt();
			int B = in.nextInt();
			int X = in.nextInt();
			int a=0,b=0,c=0,d=0;
			long hash = 0;
			if(L==1) {
				a = F;
				b = T;
				c = X;
				d = B;
				hash = R;
			}	
			else if(R==1) {
				hash = L;
				a = F;
				b = B;
				c = X;
				d = T;
			}
			else if(T==1) {
				hash = B;
				a = F;
				b = R;
				c = X;
				d = L;
			}
			else if(B==1) {
				hash = T;
				a = F;
				b = L;
				c = X;
				d = R;
			}
			else if(F==1) {
				hash = X;
				a = R;
				b = T;
				c = L;
				d = B;
			}
			else if(X==1) {
				hash = F;
				a = L;
				b = T;
				c = R;
				d = B;
			}
			if(a<=b && a<=c && a<=d) hash *= a+7*b+49*c;
			if(b<=a && b<=c && b<=d) hash *= b+7*c+49*d;
			if(c<=a && c<=b && c<=d) hash *= c+7*d+49*a;
			if(d<=a && d<=b && d<=c) hash *= d+7*a+49*b;
			if(!map.containsKey(hash)) {
				map.put(hash,new ArrayList<Integer>());
				order.add(hash);
			}
			map.get(hash).add(i);
		}
		System.out.println(map.size());
		for(Long j:order) {
			List<Integer> l = map.get(j);
			for(int i=0; i<l.size(); i++)
				System.out.print(l.get(i)+(i==l.size()-1?"":" "));
			System.out.println();
		}
    }
}
