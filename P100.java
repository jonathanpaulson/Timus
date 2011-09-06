import java.util.*;
import java.awt.*;
import java.io.*;

public class P100 {
    static StreamTokenizer in;
    public static void main(String[] args) throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int n = nextInt();
        Point[] pts = new Point[n];
        for(int i=0; i<n; i++)
            pts[i] = new Point(nextInt(),nextInt());
        Arrays.sort(pts,new Comparator<Point>() {
                public int compare(Point a,Point b) { return b.y-a.y; }
                });
        for(int i=0; i<n; i++)
            System.out.println(pts[i].x+" "+pts[i].y);
    }
    static int nextInt() throws IOException
    {
        in.nextToken();
        return (int)in.nval;
    }
}
