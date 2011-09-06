import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P219 {
    public static void main(String[] args) throws Exception {
		int L = 1000000;
		char[] A = new char[L];
		int i = 0;
		OUTER: while(true) {
			for(char a = 'a'; a<='z'; a++)
				for(char b='a'; b<='z'; b++)
					for(char c = 'a'; c<='z'; c++) {
						A[i++]=a; if(i==L) break OUTER;
						A[i++]=b; if(i==L) break OUTER;
						A[i++]=c; if(i==L) break OUTER;
					}
		}
		System.out.println(new String(A));
    }
}
