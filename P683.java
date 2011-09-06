import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P683 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println((int)Math.ceil(Math.log(n)/Math.log(2)));
		while(n>1) {
			System.out.print( (n/2)+(n==2?"":" "));
			n-=n/2;
		}
		System.out.println();
    }
}
