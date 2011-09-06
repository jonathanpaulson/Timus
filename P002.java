import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P2 {
    static String num;
    static Map<String,String> dict;
    static String[] dp;
    static int[] cost;
    static boolean[] seen;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            num = in.readLine();
            if(num.equals("-1")) break;
            dp = new String[num.length()+1];
            cost = new int[num.length()+1];
            seen = new boolean[num.length()+1];
            int n = Integer.parseInt(in.readLine());
            dict = new HashMap<String,String>();
            for(int i=0; i<n; i++) {
                String word = in.readLine();
                dict.put(to_num(word),word);
            }
            String ans = dp(num.length());
            System.out.println(ans==null?"No solution.":ans);
        }
    }
    public static String dp(int end) {
        if(seen[end])
            return dp[end];
        seen[end]=true;
        if(dict.containsKey(num.substring(0,end))) {
            cost[end] = 1;
            return dp[end]=dict.get(num.substring(0,end));
        }
        String cand = null;
        int best_cost = num.length();
        for(int i=0; i<end; i++) {
            String part = num.substring(i,end);
            String part_word = dict.get(part);
            String rest = dp(i);
            int my_cost = cost[i]+1;
            if(dict.containsKey(part) && rest!=null && (cand==null || my_cost < best_cost)) {
                cand = rest+" "+part_word;
                best_cost = my_cost;
            }
        }
        cost[end] = best_cost;
        return dp[end]=cand;
    }
    public static String to_num(String s) {
                     /*a   b   c   d   e   f   g   h   i   j   k   l   m   n   o   p   q   r   s   t   u   v   w   x   y   z */
        char[] map = {'2','2','2','3','3','3','4','4','1','1','5','5','6','6','0','7','0','7','7','8','8','8','9','9','9','0'};
        String ans = "";
        for(int i=0; i<s.length(); i++)
            ans+=map[s.charAt(i)-'a'];
        return ans;
    }
}
