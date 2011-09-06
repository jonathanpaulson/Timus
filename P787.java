import java.util.*;
import java.awt.Point;
import java.math.*;

public class P787 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum+=in.nextInt();
            sum = Math.max(sum-k,0);
        }
        System.out.println(sum);
    }
}
