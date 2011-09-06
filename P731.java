import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P731 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        for(int i=1; i<=n; i++)
            System.out.print(i+(i==n?"":" "));
        System.out.println();
        for(int j=1; j<=m; j++)
            System.out.print( (3*n*j)+(j==m?"":" "));
        System.out.println();
    }
}
