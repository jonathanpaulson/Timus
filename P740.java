import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P740 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        double L = in.nextInt();
        double K = in.nextInt();
        double H = in.nextInt();

        double T = L/K;
        if(T > (int)T) System.out.println( (H*(int)T)+" "+(H*(1+(int)T)) );
        else System.out.println( (H*(int)T)+" "+(H*(int)T) );
    }
}
