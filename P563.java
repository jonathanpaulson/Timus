import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P563 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        Set<String> S = new HashSet<String>();
        int cnt = 0;
        for(int i=0; i<n; i++) {
            String s = in.nextLine();
            if(S.contains(s)) cnt++;
            S.add(s);
        }
        System.out.println(cnt);
    }
}
