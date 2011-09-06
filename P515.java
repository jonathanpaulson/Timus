import java.util.*;
import java.awt.Point;
import java.math.*;

public class P515 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int next = 1;
        for(int i=0; i<n; i++) {
            int num = in.nextInt();
            if(num > next) { System.out.println(next); System.exit(0);}
            next += num;
        }
        System.out.println(next);
    }
}
