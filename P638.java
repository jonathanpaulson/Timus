import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P638 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int C = in.nextInt();
        int start = in.nextInt();
        int end = in.nextInt();
        if(start == end) System.out.println(T);
        else if(start > end)
            System.out.println ( T+C+(start-end-1)*(2*C+T)+T+C);
        else System.out.println( C+(end-start-1)*(2*C+T)+C );
    }
}
