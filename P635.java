import java.util.*;
import java.awt.Point;
import java.math.*;

public class P635 {
    static String line;
    static short[] dp;
    static boolean[][] pal;
    static boolean[][] pseen;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        dp = new short[line.length()+1];
        pal = new boolean[line.length()+1][line.length()+1];
        pseen = new boolean[line.length()+1][line.length()+1];
        for(int i=line.length()-1; i>=0; i--)
            dp(i);
        for(int i=0; i<line.length(); i++) {
            for(int j=0; j<line.length(); j++) {
                palindrome(i,j);
            }
        }
        System.out.println(dp(0));
        extract(0,line.length());
        System.out.println();
    }
    public static short dp(int start) {
        if(start >= line.length())
            return 0;
        if(dp[start] > 0)
            return dp[start];
        short min = 4000;
        for(int i=start; i<line.length(); i++)
            if(palindrome(start,i))
                min = (short)Math.min(min,1+(short)dp(i+1));
        return dp[start]=min;
    }
    public static boolean palindrome(int start,int end) {
        if(start >= end) return true;
        if(pseen[start][end]) return pal[start][end];
        pseen[start][end]=true;
        if(line.charAt(start) != line.charAt(end))
            return pal[start][end]=false;
        return pal[start][end]=palindrome(start+1,end-1);
    }
    public static void extract(int start,int end) {
        while(start < end) {
            INNER: for(int i=start+1; i<=end; i++) {
                if(palindrome(start,i-1) && dp(i)==dp(start)-1) {
                    System.out.print(line.substring(start,i)+(i==end?"":" "));
                    start = i;
                    break INNER;
                }
            }
        }
    }
}
