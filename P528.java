import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P528 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        while(true) {
            int n = in.nextInt();
            int p = in.nextInt();
            if(n==0 && p==0) break;
            System.out.println(f(n,p));
        }
    }
    public static long f(int n,int p) {
        long ans = 1;
        for(int i=2; i<=n; i++)
            ans = (ans*i)%p;
        return ans;
    }
}
