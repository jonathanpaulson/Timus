import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P354 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        int best_len = 20001;
        String cand = "";
        for(int c = s.length()/2; c<s.length(); c++) {
            int in_len = 2*c+1;
            int out_len = 2*c+2;
            if(in_len < best_len && in_len > s.length()) {
                boolean ok = true;
                for(int i=1; i+c<s.length(); i++)
                    if(s.charAt(c+i) != s.charAt(c-i))
                        ok = false;
                if(ok) {
                    char[] ans = new char[c*2+1];
                    for(int i=0; i<=c; i++) {
                        ans[i] = s.charAt(i);
                        ans[2*c-i] = s.charAt(i);
                    }
                    best_len = in_len;
                    cand = new String(ans);
                }
            }
            if(out_len < best_len) {
                boolean ok = true;
                for(int i=0; c+1+i<s.length(); i++)
                    if(s.charAt(c-i) != s.charAt(c+1+i))
                        ok = false;
                if(ok) {
                    char[] ans = new char[c*2+2];
                    for(int i=0; i<=c; i++) {
                        ans[i] = s.charAt(i);
                        ans[2*c+1-i] = s.charAt(i);
                    }
                    best_len = out_len;
                    cand = new String(ans);
                }
            }
        }
        System.out.println(cand);
    }
}
