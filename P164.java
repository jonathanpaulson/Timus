import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P164 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] cnts = new int[256];
        int N = in.nextInt();
        int M = in.nextInt();
        int P = in.nextInt(); in.nextLine();
        for(int i=0; i<N; i++) {
            String s = in.nextLine();
            for(int j=0; j<M; j++)
                cnts[s.charAt(j)]++;
        }
        for(int i=0; i<P; i++) {
            String s = in.nextLine();
            for(int j=0; j<s.length(); j++)
                cnts[s.charAt(j)]--;
        }
        String ans = "";
        for(int i=0; i<256; i++)
            for(int j=0; j<cnts[i]; j++)
                ans+=(char)i;
        System.out.println(ans);
    }
}
