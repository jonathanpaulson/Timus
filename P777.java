import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P777 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        List<Long> L = new ArrayList<Long>();
        L.add(in.nextLong());
        L.add(in.nextLong());
        L.add(in.nextLong());
        long min = abs(L.get(0)-L.get(1));
        min = min(min,abs(L.get(0)-L.get(2)));
        min = min(min,abs(L.get(1)-L.get(2)));
        int cnt = 0;
        while(min > 0) {
            cnt++;
            long add = min;
            for(int i=0; i<L.size(); i++)
                min = min(min,abs(add-L.get(i)));
            L.add(add);
        }
        System.out.println(cnt+1);
    }
}
