import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P821 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeMap<Double,StringTime> map = new TreeMap<Double,StringTime>();
        for(int i=0; i<n; i++) {
            String name = in.next();
            String[] arr = in.next().split(":");
            double time = Integer.parseInt(arr[0])*60+Double.parseDouble(arr[1]);
            map.put(time+30*i,new StringTime(name,time));
        }

        List<String> ans = new ArrayList<String>();
        double best = 1e10;
        for(StringTime st:map.values()) {
            if(st.time < best) {
                ans.add(st.name);
                best = st.time;
            }
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for(String s:ans) System.out.println(s);
    }

    private static class StringTime {
        String name;
        double time;
        public StringTime(String s,double d) {
            name = s;
            time = d;
        }
    }
}
