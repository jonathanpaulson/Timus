import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P613 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Set<Integer>[] sets = (HashSet<Integer> []) new HashSet[n];
        String[] arr = in.readLine().split(" ");
        sets[0] = new HashSet<Integer>();
        sets[0].add(Integer.parseInt(arr[0]);
        for(int i=1; i<n; i++) {
            sets[i] = new HashSet<Integer>
        }
            map.put(i,Integer.parseInt(arr[i-1]));
        int q = Integer.parseInt(in.readLine());
        char[] ans = new char[q];
        for(int i=1; i<=q; i++) {
            arr = in.readLine().split(" ");
            int L = Integer.parseInt(arr[0]);
            int R = Integer.parseInt(arr[1]);
            int x = Integer.parseInt(arr[2]);
            ans[i-1] = map.headMap(R+1).tailMap(L).values().contains(x) ? '1' : '0';
        }
        System.out.println(new String(ans));
    }
}
