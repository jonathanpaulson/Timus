import java.util.*;
import java.awt.Point;
import java.math.*;

public class P200 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double A = in.nextDouble();
        double B = in.nextDouble();
        int k = in.nextInt();

        int a = 0;
        int b = 0;
        while(a+b < k) {
            if(A-2*a-1>B-2*b-1 && A-2*a-1>0)
                a++;
            else if(B-2*b-1>0) b++;
            else break;
        }
        System.out.printf("%.2f\n%d %d\n",a*A-a*a+b*B-b*b,a,b);
    }
}
