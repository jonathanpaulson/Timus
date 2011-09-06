import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P262 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int[] digits = new int[]{0,1,2,3,2,1,2,3,4,2};
        String line = in.nextLine();
        int ans = 0;
        for(int i=0; i<line.length(); i++)
            ans += digits[line.charAt(i)-'0'];
        System.out.println(ans);
    }
}
