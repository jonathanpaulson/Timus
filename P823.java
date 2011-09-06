import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P823 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        double R = 8.314;
        double p = -1;
        double n = -1;
        double V = -1;
        double T = -1;
        for(int i=0; i<3; i++) {
            String[] arr = in.nextLine().split(" ");
            switch (arr[0].charAt(0)) {
                case 'p': p = Integer.parseInt(arr[2]); break;
                case 'n': n = Integer.parseInt(arr[2]); break;
                case 'V': V = Integer.parseInt(arr[2]); break;
                case 'T': T = Integer.parseInt(arr[2]); break;
            }
        }

        if(p == -1)
        {
            System.out.printf("p = %.5f\n",n*R*T/V);
        }
        if(V == -1) {
            if( (n==0 && p>0) || (p==0 && n>0) ) System.out.println("error");
            else if(p==0) System.out.println("undefined");
            else System.out.printf("V = %.5f\n",n*R*T/p);
        }
        if(n == -1) {
            System.out.printf("n = %.5f\n", p*V/(R*T));
        }
        if(T == -1) {
            if( (n>0 && p==0) || (n==0 && p>0) ) System.out.println("error");
            else if(n==0) System.out.println("undefined");
            else System.out.printf("T = %.5f\n", p*V/(R*n));
        }
    }
}
