import java.util.*;
import java.awt.Point;
import java.math.*;

public class P228 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt()-1;
        for(int i=0; i<n; i++) {
            int d = in.nextInt();
            System.out.print(s/d+(i==n-1?"":" "));
            s-=s/d*d;
        }
    }
}
