import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P576 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int N1 = in.nextInt();
        int C1 = in.nextInt();
        int N2 = in.nextInt();
        int T = in.nextInt();
        int C2 = in.nextInt();
        int N3 = in.nextInt();
        int k = in.nextInt();
        int min = 0;
        for(int i=0; i<k; i++) {
            String[] arr = in.next().split(":");
            int m = Integer.parseInt(arr[0]);
            int s = Integer.parseInt(arr[1]);
            if(m==0 && s<=6) continue;
            if(s!=0) m++;
            min+=m;
        }
        System.out.println("Basic:     "+(N1+C1*min));
        System.out.println("Combined:  "+(N2+max(0,(min-T)*C2)));
        System.out.println("Unlimited: "+N3);
    
    }
}
