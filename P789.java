import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P789 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n==1) { System.out.println("1\n1"); }
        if(n==2) { System.out.println("2\n1 1"); }
        if(n>2) {
            System.out.println( (n-2)*2 );
            for(int i=2; i<=n-1; i++)
                System.out.print(i+" ");
            for(int i=n-1; i>=2; i--)
                System.out.print(i+(i==2?"":" "));
            System.out.println();
        }
    }
}
