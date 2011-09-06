import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P581 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int cur = in.nextInt();
        int cnt = 1;
        for(int i=1; i<n; i++) {
            int val = in.nextInt();
            if(val == cur) cnt++;
            else {
                System.out.print(cnt+" "+cur+" ");
                cur = val;
                cnt = 1;
            }
        }
        System.out.print(cnt+" "+cur);
        System.out.println();
    }
}
