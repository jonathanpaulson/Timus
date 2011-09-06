import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P654 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
		String s = in.nextLine();
        char[] ans = new char[s.length()];
        int ix = -1;
        for(int i=0; i<s.length(); i++) {
            if(ix >= 0 && s.charAt(i)==ans[ix])
                ix--;
            else ans[++ix] = s.charAt(i);
        }
        char[] print = new char[ix+1];
        for(int i=0; i<=ix; i++)
            print[i] = ans[i];
        System.out.println(new String(print));
    }
}
