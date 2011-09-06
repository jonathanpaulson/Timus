import java.util.*;

public class P53 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long gcd = in.nextLong();
        for(int i=1; i<n; i++)
            gcd = gcd(gcd,in.nextLong());
        System.out.println(gcd);    
    }
    public static long gcd(long x,long y) {
        if(x==0) return y;
        return gcd(y%x,x);
    }
}
