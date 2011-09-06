import java.util.*;
import java.awt.Point;
import java.math.*;

public class P149 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        S(n,1);
        System.out.println();
    }
    public static void S(int n,int k) {
        if(n==0) return;
        if(n>1) {
            System.out.print("(");
            S(n-1,k+1);
            System.out.print(")");
        }
        A(n,1,false);
        System.out.print("+"+k);
    }
    public static void A(int n,int k,boolean flag) {
        if(n==0) return;
        System.out.print("sin("+k);
        if(n>1) System.out.print(flag?'+':'-');
        A(n-1,k+1,!flag);
        System.out.print(")");
    }
}
