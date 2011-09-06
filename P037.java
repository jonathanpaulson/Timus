import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P37 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeSet<Integer> free = new TreeSet<Integer>();
        for(int i=1; i<=30000; i++)
            free.add(i);
        TreeMap<Integer,List<Integer>> alloc = new TreeMap<Integer,List<Integer>>();
        TreeMap<Integer,Integer> alloc2 = new TreeMap<Integer,Integer>();
        while(in.hasNext()) {
            int t = in.nextInt();
            for(Iterator<Integer> iter = alloc.keySet().iterator();iter.hasNext();) {
                Integer i = iter.next();
                if(i>t) break;
                for(Integer j:alloc.get(i)) {
                    free.add(j);
                    alloc2.remove(j);
                }
                iter.remove();
            }
            //System.out.println(t+" "+alloc);
            if(in.next().equals(".")) {
                int where = in.nextInt();
                if(free.contains(where)) { 
                    System.out.println("-");
                } else {
                    System.out.println("+");
                    int time = alloc2.get(where);
                    alloc.get(time).remove((Integer)where);
                    if(!alloc.containsKey(t+600))
                        alloc.put(t+600,new ArrayList<Integer>());
                    alloc2.put(where,t+600);
                    alloc.get(t+600).add(where); 
                }
            }
            else {
                int to_alloc = free.first();
                free.remove(to_alloc);
                if(!alloc.containsKey(t+600))
                    alloc.put(t+600,new ArrayList<Integer>());
                alloc.get(t+600).add(to_alloc);
                alloc2.put(to_alloc,t+600);
                System.out.println(to_alloc);
            }
        }
    }
}
