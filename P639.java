import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P639 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if( (n*m)%2 == 1) System.out.println("[second]=:]");
        else System.out.println("[:=[first]");
    }
}
