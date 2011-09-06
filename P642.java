import java.util.*;
import java.awt.Point;
import java.math.*;

public class P642 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int e = in.nextInt();
        int max_neg = -1100;
        int min_pos = 1100;
        for(int i=0; i<n; i++) {
            int o = in.nextInt();
            if(o>0 && o<min_pos) min_pos = o;
            if(o<0 && o>max_neg) max_neg = o;
        }
        if((e<0 && e<max_neg) || (e>0 && e>min_pos))
            { System.out.println("Impossible"); return; }
        if(e==0) System.out.println("0 0");
        else if(e>0) System.out.println(e+" "+(e-2*max_neg));
        else System.out.println((2*min_pos-e)+" "+(-e));
    }
}
