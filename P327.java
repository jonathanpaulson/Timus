import java.util.*;

public class P327 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int ans = (b-a)/2;
        if(b%2==1 || a%2==1) ans++;
        System.out.println(ans);
    }
}
