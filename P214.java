import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P214 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*for(int i=0; i<10; i++)
            for(int j=0; j<10; j++)
                System.out.println(i+" "+j+" "+P(i,j));
        */
        long x = in.nextLong();
        long y = in.nextLong();
        if(x>0 && y>0 && ((x%2)!=(y%2)))
            System.out.println(y+" "+x);
        else System.out.println(x+" "+y);
    }

    public static Point P(int x,int y)
    {
        int i, j;
        if (x>0 && y>0)
        {
            for (i = 1; i <= x+y; i++)
            {
                y = x*x+y;
                x = x*x+y;
                y = (int)sqrt(x+(y/abs(y))*(-abs(y)));
                for (j = 1; j <= 2*y; j++)
                    x = x-y;
            }
        }
        return new Point(x,y);
    }
}
