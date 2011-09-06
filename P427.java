import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P427 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt(); in.nextLine();

        boolean ok = true;
        int L = 0;
        int cnt = 0;
        String s = in.nextLine();
        for(int i=0; i<s.length(); i++) {
        //    System.out.println(s.charAt(i)+" "+L+" "+ok+" "+cnt);
            L++;
            if(!f(s.charAt(i))) ok = false;
            if(!ok && L > n) {
                L = 1;
                ok = false;
                cnt++;
            }
            if(!ok && L==n) {
                L = 0;
                ok = true;
                cnt++;
            }
            if(L == m) {
                L = 0;
                ok = true;
                cnt++;
            }
        }
        if(L > 0) cnt++;
        System.out.println(cnt);
    }
    public static boolean f(char c) {
        return c==' ' || (c>='a' && c<='z') || (c>='A' && c<='Z');
    }
}
