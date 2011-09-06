import java.util.*;

public class P11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble()/100;
        double b = in.nextDouble()/100;
        for(int d=1;; d++) {
            for(int n=1; n<d; n++) {
                double frac = ((double)n)/d;
                if(a < frac-1e-9 && frac+1e-9 < b)
                    { System.out.println(d); System.exit(0); }
            }
        }
    }
}
