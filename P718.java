import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P718 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        Set<String> lo = new HashSet<String>();
        Set<String> hi = new HashSet<String>();
        for(int i=0; i<n; i++) {
            String[] arr = in.nextLine().split(" ");
            if(arr.length == 3 && Integer.parseInt(arr[2])>=7)
                lo.add(arr[0]);
            if(arr[1].equals("AC") || (arr.length == 3 && Integer.parseInt(arr[2])>=6))
               hi.add(arr[0]);
        }
        System.out.println(lo.size()+" "+hi.size());
    }
}
