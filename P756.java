import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P756 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int cost = in.nextInt()*in.nextInt();
        int d2 = in.nextInt();
        int max = (int)ceil(cost/(double)d2);
        for(int i=0; i<d2; i++) {
            System.out.print(min(cost,max)+(i==d2-1?"":" "));
            cost-=min(cost,max);
        }
        System.out.println();
    }
}
