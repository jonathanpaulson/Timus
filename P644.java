import java.util.*;
import java.awt.Point;
import java.math.*;

public class P644 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        int min = 2;
        int max = 10;
        for(int i=0; i<n; i++) {
            String[] arr = in.nextLine().split(" ");
            if(arr[1].equals("hungry"))
                min = Math.max(min,Integer.parseInt(arr[0]));
            else max = Math.min(max,Integer.parseInt(arr[0]));
        }
        if(min >= max) { System.out.println("Inconsistent"); return; }
        System.out.println(max);
    }
}
