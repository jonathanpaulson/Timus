import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P238 {
	public static String dp[][];
	static String s;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		s =  in.nextLine();
		dp = new String[s.length()][s.length()];
		String ans = dp(0,s.length()-1);
		System.out.println(ans);
    }
	public static String dp(int start,int end) {
		if(dp[start][end] != null) return dp[start][end];
		if(start==end) return dp[start][end]=s.charAt(start)+"";

		String best = s.substring(start,end+1);
		for(int i=start; i<end; i++) {
			String p1 = dp(start,i);
			String p2 = dp(i+1,end);
			if(p1.length()+p2.length() <= best.length()) {
				best = p1+p2;
			}
		}

		int L = end-start+1;
		OUTER: for(int len=1; len<=L/2; len++) {
			if( (L%len) != 0) continue;
			String p = s.substring(start,start+len);
			for(int i=start; i<=end; i+=len)
				if(!p.equals(s.substring(i,i+len)))
					continue OUTER;
			String cand = (L/len)+"("+dp(start,start+len-1)+")";
			if(cand.length() <= best.length())
				best = cand;
		}
		return dp[start][end]=best;
	}
}
