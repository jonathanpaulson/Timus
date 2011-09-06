import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P247 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int[] data = new int[s];
        for(int i=0; i<s; i++) data[i]=in.nextInt();

        int sum = 0;
        for(int i=0; i<s; i++) {
            sum+=data[i];
            if(sum<(i+1)) { System.out.println("NO"); return; }
        }

        sum = 0;
        for(int i=0; i<s; i++) {
            sum+=data[s-1-i];
            if(sum<(i+1)) { System.out.println("NO"); return; }
        }

        System.out.println("YES");
    }
}
