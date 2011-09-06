import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P102 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String regex = "^(puton|out|output|in|input|one)*$";
        OUT: for(int i=0; i<n; i++) {
            String s = in.readLine();
            System.out.println(Pattern.matches(regex,s)?"YES":"NO");
        }
    }
}
