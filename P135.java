import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P135 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        String s = "";
        while(in.hasNextLine())
            s += in.nextLine();

        int tmp = 0;
        int[] sum = new int[n];
        for(int i=n-1; i>=0; i--) {
            if(s.charAt(i)=='<') tmp++;
            sum[i]=tmp;
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            if(s.charAt(i)=='>') ans+=sum[i];
        }
        System.out.println(ans);
    }
}
