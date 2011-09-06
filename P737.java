import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P737 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n*6 > 100000) { System.out.println("TOO LONG"); return; }
        if(n==1) { System.out.println("a\nb\nc\n"); return; }
        System.out.println(template("abc",n));
        System.out.println(template("acb",n));
        System.out.println(template("bac",n));
        System.out.println(template("bca",n));
        System.out.println(template("cab",n));
        System.out.println(template("cba",n));
    }
    public static String template(String s,int n)
    {
        char[] ret = new char[n];
        for(int i=0; i<n; i++)
            ret[i] = s.charAt(i%s.length());
        return new String(ret);
    }
}
