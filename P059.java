import java.util.*;

public class P59 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        print(n);
    }
    public static void print(int n) {
        if(n==0) {
            System.out.println("0");
            return;
        }
        print(n-1);
        System.out.println("X");
        System.out.println("*");
        System.out.println(n);
        System.out.println("+");
    }
}
