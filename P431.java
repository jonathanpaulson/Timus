import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P431 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> L = new ArrayList<Integer>();
        for(int i=0; i<n; i++)
            L.add(in.nextInt());
        Collections.sort(L);
        int cnt = 0;
        while(!L.isEmpty()) {
            int x = L.remove(0);
            if(L.contains(x+1))
                L.remove(new Integer(x+1));
            cnt++;
        }
        System.out.println(cnt);
    }
}
