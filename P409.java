import java.util.*;

public class P409 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int n = a+b-1;
        System.out.println((n-a)+" "+(n-b));
    }
}
