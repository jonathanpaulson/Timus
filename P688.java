import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P688 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        long req = in.nextLong()*3;
        int m = in.nextInt();
        long sum = 0;
        for(int i=0; i<m; i++) {
            sum+=in.nextLong();
            if(sum > req) { System.out.println("Free after "+(i+1)+" times."); return; }
        }
        System.out.println("Team.GOV!");
    }
}
