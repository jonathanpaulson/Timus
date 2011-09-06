import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P792 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
		int x = 0;
		for(int i=0; i<7; i++) {
			x|=(in.nextInt()<<i);
		}
		for(int i=0; i<7; i++) {
			x^=(1<<i);
			if(hamming(x)) break;
			x^=(1<<i);
		}
		for(int i=0; i<7; i++) {
			System.out.print( (x&1)+(i==6?"":" "));
			x>>=1;
		}
		System.out.println();
    }
	public static boolean hamming(int x) {
		return n(5,x)== (n(2,x)^n(3,x)^n(4,x)) &&
			   n(6,x)== (n(1,x)^n(3,x)^n(4,x)) &&
			   n(7,x)== (n(1,x)^n(2,x)^n(4,x));
	}
	public static int n(int n,int x) {
		return (x>>(n-1))&1;
	}
}
