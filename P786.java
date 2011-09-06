import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P786 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
		int min = 1000;
		String s = in.nextLine();
		for(int i=0; i<s.length()-5; i++)
			min = min(min,cost(s.substring(i,i+6)));
		System.out.println(min);
    }
	public static int cost(String s) {
		String target = "Sandro";
		int cost = 0;
		for(int i=0; i<6; i++) {
			char m = s.charAt(i);
			char t = target.charAt(i);
			if(m==t) continue;
			if(up(m)!=up(t)) cost+=5;
			if(!same(m,t)) cost+=5;
		}
		return cost;
	}
	public static boolean up(char c) { return 'A'<=c && c<='Z'; }
	public static boolean down(char c) { return 'a'<=c && c<='z'; }
	public static boolean same(char m,char t) {
		return m==t || ((m+'A'-'a')==t) || ((m-'A'+'a') == t);
	}
}
