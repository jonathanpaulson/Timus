import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P134 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        boolean[] used = new boolean[n+2];
        used[0] = true;
        used[n+1] = true;

        int[] data = new int[m];
        for(int i=0; i<m; i++)
            data[i] = in.nextInt();
        Arrays.sort(data);
        for(int i=0; i<m; i++) {
            if(used[data[i]] && used[data[i]+1]) { System.out.println("NO"); return; }
            if(used[data[i]])
                used[data[i]+1] = true;
            else used[data[i]] = true;
        }
        System.out.println("YES");
    }
}
