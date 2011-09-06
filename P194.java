import java.util.*;

public class P194 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(n*(n-1)/2-k);
    }
}
