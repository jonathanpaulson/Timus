import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P502 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long ans = 0;
        for(int i=0; i<=N; i++)
            for(int j=i; j<=N; j++)
                ans+=i+j;
        System.out.println(ans);
    }
}
