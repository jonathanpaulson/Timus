import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P126 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        List<Integer> data = new ArrayList<Integer>();
        do {
            data.add(in.nextInt());
        } while(data.get(data.size()-1) != -1);
        data.remove(data.size()-1);
        TreeMap<Integer,Integer> S = new TreeMap<Integer,Integer>();
        for(int i=0; i<M; i++) {
            S.put(data.get(i),1+(S.containsKey(data.get(i))?S.get(data.get(i)):0));
        }
        for(int i=0;; i++) {
            System.out.println(S.lastKey());
            if(S.get(data.get(i))==1) S.remove(data.get(i));
            else S.put(data.get(i),S.get(data.get(i))-1);
            if(i+M>=data.size()) break;
            S.put(data.get(i+M),1+(S.containsKey(data.get(i+M))?S.get(data.get(i+M)):0));
        }
    }
}
