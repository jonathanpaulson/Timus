import java.util.*;

public class P68 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = Math.abs(n)*(Math.abs(n)+1)/2;
        if(n<1) ans = -ans+1;
        System.out.println(ans);
    }
}
