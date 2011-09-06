import java.util.*;
import java.awt.Point;
import java.math.*;

public class P98 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String q = "";
        while(in.hasNextLine())
            q+=in.nextLine();
        int n = q.length();
        int k = 1999;
        int survivor = f(n,k);
        switch(q.charAt(survivor)) {
            case '?': System.out.println("Yes"); break;
            case ' ': System.out.println("No"); break;
            default: System.out.println("No comments"); break;
        }
    }
    public static int f(int n,int k) {
        if(n==1) return 0;
        return (f(n-1,k)+k) % n;
    }
}
