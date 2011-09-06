import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P406 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        char[] arr = in.nextLine().toCharArray();
        for(int i=arr.length-1; i>=0; i--) {
            if(arr[i] > '0') {
                if(i==0) { System.out.println(-1); return; }
                if(arr[i-1] < '9') {
                    arr[i-1]++;
                    arr[i]--;
                    System.out.println(new String(arr));
                    return;
                }


            }
        }
    }
}
