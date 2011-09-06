import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P779 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        List<Point> edges = new ArrayList<Point>();
        int n = in.nextInt();
        for(int i=1; i<=n/2; i++)
        {
            for(int j=0; j<i; j++)
                edges.add(new Point(i,n/2+n/2-j));
        }
        System.out.println(edges.size());
        for(Point p:edges) System.out.println(p.x+" "+p.y);
    }
}
