import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P680 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        in.nextInt();
        in.nextInt();
        int q = in.nextInt(); in.nextLine();
        Set<String> seen = new HashSet<String>();
        while(true) {
            String s = in.nextLine();
            String name = s.substring(0,s.lastIndexOf(' '));
            if(seen.contains(name)) continue;
            seen.add(name);
            q--;
            if(q==-1) { System.out.println(s); return; }
        }
    }
}
