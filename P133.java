import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P133 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int fi = in.nextInt();
        if(i<0) { i=-i; if(i%2==1) fi=-fi; }
        int j = in.nextInt();
        int fj = in.nextInt();
        if(j<0) { j=-j; if(j%2==1) fj=-fj; }
        if(i>j) { 
            int tmp = i; i=j; j=tmp;
            tmp = fi; fi = fj; fj = tmp;
        }
        int n = in.nextInt();

        
        int zero,one;
        if(i==0)  {
            zero = fi;
            one = fj-zero*f(j-2)/f(j-1); 
        }
        else if(i==1) {
            one = fi;
            zero = 
        }
    }
}
