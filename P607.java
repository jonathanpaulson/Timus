import java.util.*;
import java.awt.Point;
import java.math.*;

public class P607 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int da = in.nextInt();
        int b = in.nextInt();
        int db = in.nextInt();
        b+=db;
        while(true) {
            if(b-db <= a) { System.out.println(a); return; }
            b-=db;
            if(a+da >= b) { System.out.println(b); return; }
            a+=da;
        }
    }
}
