import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P551 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        int L = (int)pow(2,n);
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0; i<L; i++) {
            String[] arr = in.nextLine().split(" ");
            if(!map.containsKey(arr[1])) map.put(arr[1],1);
            else map.put(arr[1],map.get(arr[1])+1);
        }

        int max = 0;
        for(Integer i:map.values()) max = max(max,i);

        for(int k=1;; k++) {
            L/=2;
            if(max > L) { System.out.println(k-1); return; }
        }
    }
}
