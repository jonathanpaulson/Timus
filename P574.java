import java.util.*;
import java.awt.Point;
import java.math.*;

public class P574 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int count = 0;
        for(int i=0; i<line.length(); i++)
            if(cyclic(i,line))
                count++;
        System.out.println(count);
    }
    public static boolean cyclic(int shift,String line) {
        int rcnt = 0;
        int scnt = 0;
        for(int i=0; i<line.length(); i++) {
            if(line.charAt(i)=='(') { rcnt++; }
            if(line.charAt(j)=='[') { scnt++; }
        }
    }
}
