import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P645 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] pos = new int[n+1];
        for(int i=1; i<=n; i++)
            pos[in.nextInt()] = i;

        for(int i=1; i<=n; i++) {
            int worse = 0;
            int better = 0;
            for(int j=1; j<i; j++)
                if(pos[j] > pos[i]) worse++;
            for(int j=i+1; j<=n; j++)
                if(pos[j] < pos[i]) better++;
            System.out.println( (better+1)+" "+(n-worse) );
        }
    }
}
