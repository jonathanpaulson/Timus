import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P795 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Map<String,Integer> map = new HashMap<String,Integer>();
        int m = in.nextInt(); in.nextLine();
        for(int i=0; i<m; i++) {
            String[] arr = in.nextLine().split(" ");
            map.put(arr[2],Integer.parseInt(arr[0]));
        }

        int n = in.nextInt(); in.nextLine();
        LinkedList<String[]> L = new LinkedList<String[]>();
        for(int i=0; i<n; i++)
            L.add(in.nextLine().split(" "));
        long time = 0;
        while(!L.isEmpty()) {
            time++;
            String[] cur = L.removeFirst();
            if(!map.containsKey(cur[2])) continue;
            int amt = Integer.parseInt(cur[0]);
            if(map.get(cur[2]) >= amt) {
                if(map.get(cur[2]) == amt) map.remove(cur[2]);
                else map.put(cur[2],map.get(cur[2])-amt);
            }
            else {
                cur[0] = map.get(cur[2])+"";
                if(!L.isEmpty()) L.add(1,cur);
                else { System.out.println(time); return; }
            }
        }
        System.out.println(time);
    }
}
