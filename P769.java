import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P769 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        for(int L=1;; L++) {
            Set<String> seen = new HashSet<String>();
            for(int i=0; i<=s.length()-L; i++)
                seen.add(s.substring(i,i+L));

            int lo = (int)Math.pow(10,L-1);
            int hi = (int)Math.pow(10,L)-1;
            for(int n=lo; n<=hi; n++)
                if(!seen.contains(n+"")) { System.out.println(n); return; }
        }
    }
}
