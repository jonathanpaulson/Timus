import java.util.*;
import java.awt.Point;
import java.math.*;

public class P180 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = 0;
        for(int i=s.length()-1; i>=0; i--)
            n = ((n*10)+(s.charAt(i)-'0')) % 3;
        if(n==0) System.out.println(2);
        else System.out.println(1+"\n"+n);
    }
}
