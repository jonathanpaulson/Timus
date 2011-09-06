import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P572 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        double L = big(in.nextInt(),in.nextInt());
        int n = in.nextInt();
        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(small(in.nextInt(),in.nextInt()) <= L) cnt++;
        }
        System.out.println(cnt);
    }
    public static double big(int hole, int L) {
        if(hole == 1) return L*2;
        if(hole == 2) return L*sqrt(2);
        if(hole == 3) return L;
        return 0;
    }
    public static double small(int hole, int L) {
        if(hole == 1) return L*2;
        if(hole == 2) return L;
        if(hole == 3) return L*sqrt(3)/2;
        return 0;
    }
}
