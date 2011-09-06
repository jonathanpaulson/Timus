import java.util.*;
import java.awt.Point;
import java.math.*;

public class P636 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int penalty = 0;
        for(int i=0; i<10; i++)
            penalty+=in.nextInt()*20;
        if(a+penalty > b)
            System.out.println("Dirty debug :(");
        else System.out.println("No chance.");
    }
}
