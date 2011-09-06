import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P510 {
    public static void main(String[] args) throws Exception {
        //Scanner in = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int cnt = 1;
        int cur = Integer.parseInt(in.readLine());
        for(int i=1; i<n; i++) {
            int val = Integer.parseInt(in.readLine());
            if(val == cur) cnt++;
            else cnt--;
            if(cnt == 0) { cur=val; cnt=1; }
        }
        System.out.println(cur);
    }
}
