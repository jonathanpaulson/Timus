import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P785 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n<=4) { System.out.println("few"); return; }
		if(n<=9) { System.out.println("several"); return; }
		if(n<=19) { System.out.println("pack"); return; }
		if(n<=49) { System.out.println("lots"); return; }
		if(n<=99) { System.out.println("horde"); return; }
		if(n<=249) { System.out.println("throng"); return; }
		if(n<=499) { System.out.println("swarm"); return; }
		if(n<=999) { System.out.println("zounds"); return; }
		System.out.println("legion");
    }
}
