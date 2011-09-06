import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P604 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeSet<Point> S = new TreeSet<Point>(new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                if(p1.x != p2.x)
                    return p1.x-p2.x;
                return p1.y-p2.y;
            } 
        });
        for(int i=1; i<=n; i++)
            S.add(new Point(in.nextInt(),i));

        List<Integer> ans = new ArrayList<Integer>();
        while(!S.isEmpty()) {
            Point p1 = S.last();
            S.remove(p1);
            ans.add(p1.y);

            if(!S.isEmpty()) {
                Point p2 = S.last();
                S.remove(p2);
                ans.add(p2.y);
                if(p2.x - 1 > 0) {
                    S.add(new Point(p2.x-1,p2.y));
                }
            }

            if(p1.x - 1 > 0)
                S.add(new Point(p1.x-1,p1.y));
        }
        for(int i=0; i<ans.size(); i++)
            System.out.print(ans.get(i)+(i==ans.size()-1?"\n":" "));
    }
}
