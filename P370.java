import java.util.*;
import java.awt.Point;
import java.math.*;

public class P370 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] data = new int[n];
        for(int i=0; i<n; i++) data[i]=in.nextInt();
        m%=n;
        for(int i=m; i<m+10; i++) {
            System.out.print(data[(i%n)]);
        }
        System.out.println();
    }
}
