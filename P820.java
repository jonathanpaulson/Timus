import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P820 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
		int sides = in.nextInt()*2;
		int k = in.nextInt();
		int ans = (int)Math.ceil((double)sides/k);
		System.out.println(Math.max(ans,2));
    }
}
