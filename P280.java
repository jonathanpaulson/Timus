import java.util.*;
import java.awt.Point;
import java.math.*;

public class P280 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Set<Point> set = new HashSet<Point>();
        for(int i=0; i<m; i++)
            set.add(new Point(in.nextInt(),in.nextInt()));
        int[] data = new int[n];
        for(int i=0; i<n; i++)
            data[i] = in.nextInt();
        for(int i=0; i<n; i++)
            for(int j=i+1; j<n; j++)
                if(set.contains(new Point(data[j],data[i])))
                    { System.out.println("NO"); return; }
        System.out.println("YES");
    }
}
