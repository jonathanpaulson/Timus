import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P725 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if(k > n/2) k=n+1-k;
        System.out.println(max(0,n-2-k));
    }
}
