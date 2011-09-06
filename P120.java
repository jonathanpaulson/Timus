import java.util.*;

public class P120 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long best_L = 1;
        long best_H = 1;
        long start = (long)Math.sqrt(3*n);
        for(long P=start; P>=1; P--) {
            if( (n-P*(P-1)/2)%P == 0) {
                    long A = (n-P*(P-1)/2)/P;
                    if(A<1) continue;
                    System.out.println(A+" "+P);
                    System.exit(0);
            }
            /*
            if(tri(H*(H+1)/2-n)) {
                long L = (1+(long)Math.sqrt(1-8*n+4*H*(H+1)))/2;
                if(Math.abs(H-L)>=Math.abs(best_L-best_H)) {
                    best_L = L;
                    best_H = H;
                }
            }*/
        }
    }
    public static boolean tri(long n) {
        double d = Math.sqrt(1+8*n);
        return d == (int)d;
    }
}
