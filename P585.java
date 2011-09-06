import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P585 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int n = in.nextInt(); in.nextLine();
        for(int i=0; i<n; i++) {
            String s = in.nextLine();
            if(s.equals("Macaroni Penguin")) c1++;
            if(s.equals("Little Penguin")) c2++;
            if(s.equals("Emperor Penguin")) c3++;
        }
        if(c1>c2 && c1>c3) System.out.println("Macaroni Penguin");
        if(c2>c1 && c2>c3) System.out.println("Little Penguin");
        if(c3>c2 && c3>c1) System.out.println("Emperor Penguin");
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    }
}
