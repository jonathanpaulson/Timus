import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P796 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
		int[] types = new int[]{10,50,100, 500, 1000,5000};
		int amt = 0;
		int min = 0;
		for(Integer cost:types) {
			int num = in.nextInt();
			if(num > 0 && min==0) min = cost;
			amt += num*cost;
		}
		int T = in.nextInt();
		int low = amt-min;
		
		int lo = 1+low/T;
		int hi = amt/T;
		System.out.println(hi-lo+1);
		for(int i=lo; i<=hi; i++)
			System.out.print(i+(i==hi?"":" "));
		System.out.println();
    }
}
