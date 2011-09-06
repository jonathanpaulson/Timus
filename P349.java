import java.util.*;

public class P349 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n==0 || n>2) System.out.println("-1");
        if(n==1) System.out.println("1 2 3");
        if(n==2) System.out.println("3 4 5");
    }
}
