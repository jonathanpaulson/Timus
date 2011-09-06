import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P837 {
    static TreeMap<String,Set<String>> map = new TreeMap<String,Set<String>>();
    static TreeMap<String,Integer> ans = new TreeMap<String,Integer>();
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0; i<n; i++) {
            String one = in.next();
            String two = in.next();
            String three = in.next();
            if(!map.containsKey(one)) map.put(one,new HashSet<String>());
            if(!map.containsKey(two)) map.put(two,new HashSet<String>());
            if(!map.containsKey(three)) map.put(three,new HashSet<String>());
            map.get(one).add(two);
            map.get(one).add(three);
            map.get(two).add(one);
            map.get(two).add(three);
            map.get(three).add(one);
            map.get(three).add(two);
        }
        ans.put("Isenbaev",0);
        Queue<String> Q = new LinkedList<String>();
        if(map.containsKey("Isenbaev")) Q.offer("Isenbaev");
        while(!Q.isEmpty()) {
            String name = Q.poll();
            int d = ans.get(name)+1;
            for(String s:map.get(name)) {
                if(ans.containsKey(s)) continue;
                ans.put(s,d);
                Q.offer(s);
            }
        }
        for(String s:map.keySet()) {
            System.out.println(s+" "+(ans.containsKey(s) ? ans.get(s) : "undefined"));
        }
    }
}
