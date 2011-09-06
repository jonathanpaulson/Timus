import java.util.*;
import java.awt.Point;
import java.math.*;

public class P183 {
    static String line;
    static int[][] dp = new int[100][100];
    static List<Point> pts;
    static Map<Character,Character> matched;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        matched = new HashMap<Character,Character>();
        matched.put('(',')');
        matched.put(')','(');
        matched.put('[',']');
        matched.put(']','[');
        line = in.nextLine();
        for(int i=0; i<line.length(); i++)
            for(int j=0; j<line.length(); j++)
                dp[i][j]=-1;
        dp(0,line.length()-1);
        pts = new LinkedList<Point>();
        StringBuffer ans = new StringBuffer(line);
        extract(0,line.length()-1);
        Collections.sort(pts,new Comparator<Point>() {
            public int compare(Point a,Point b) { return b.x-a.x; }
        });
        for(Point p:pts) ans.insert(p.x,(char)p.y);
        System.out.println(ans.toString());
    }
    public static int dp(int i,int j) {
        if(i>j) return 0;
        if(dp[i][j] > -1) return dp[i][j];
        int min = 1000;
        if(line.charAt(i)=='(' && line.charAt(j)==')')
            min = Math.min(min,dp(i+1,j-1));
        else if(line.charAt(i)=='(') min = Math.min(min,1+dp(i+1,j));
        else if(line.charAt(j)==')') min = Math.min(min,1+dp(i,j-1));
        if(line.charAt(i)=='[' && line.charAt(j)==']')
            min = Math.min(min,dp(i+1,j-1));
        else if(line.charAt(i)=='[') min = Math.min(min,1+dp(i+1,j));
        else if(line.charAt(j)==']') min = Math.min(min,1+dp(i,j-1));

        for(int k=i; k<j; k++)
            min = Math.min(min,dp(i,k)+dp(k+1,j));
        return dp[i][j]=min;
    }
    public static void extract(int left,int right) {
            if(left>right) return;
            //System.out.println(left+" "+right);
            if(left==right) { 
                if(line.charAt(left)=='(' || line.charAt(left)=='[')
                     pts.add(new Point(left+1,matched.get(line.charAt(left))));
                else pts.add(new Point(left,matched.get(line.charAt(left))));
            }
            else if(line.charAt(right)==matched.get(line.charAt(left)) && dp[left+1][right-1]==dp[left][right]) {
                extract(left+1,right-1);
            }
            else if((line.charAt(left)=='(' || line.charAt(left)=='[') && dp[left+1][right] == dp[left][right]-1) {
                pts.add(new Point(right+1,matched.get(line.charAt(left))));
                extract(left+1,right);
            }
            else if((line.charAt(right)==')' && line.charAt(right)==']') && dp[left][right-1] == dp[left][right]-1) {
                pts.add(new Point(left,matched.get(line.charAt(right))));
                extract(left,right-1);
            }
            else {
                for(int k=left; k<right; k++) {
                    if(dp[left][k]+dp[k+1][right]==dp[left][right]) {
                        extract(left,k);
                        extract(k+1,right);
                        return;
                    }
                }
            }
    }
}
