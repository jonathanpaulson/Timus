import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P573 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int B = in.nextInt();
        int R = in.nextInt();
        int Y = in.nextInt();
        int ans = 1;
        int k = in.nextInt();
        for(int i=0; i<k; i++) {
            String s = in.next();
            if(s.equals("Red")) ans*=R;
            if(s.equals("Blue")) ans*=B;
            if(s.equals("Yellow")) ans*=Y;
        }
        System.out.println(ans);
    }
}
