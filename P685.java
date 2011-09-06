import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P685 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println(decode(in.nextLine()));
    }
    public static String decode(String s)
    {
        if(s.length()<=1) return s;
        int mid = (s.length()+1)/2-1;
        return decode(s.substring(1,1+mid))+s.charAt(0)+decode(s.substring(1+mid));
    }
}
