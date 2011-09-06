import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P700 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Map<String,Set<String>> map = new HashMap<String,Set<String>>();
        int n = in.nextInt(); in.nextLine();
        for(int i=0; i<n; i++) {
            String[] arr = in.nextLine().split(" ");
            String name = arr[0].substring(0,arr[0].length()-1);
            map.put(name,new HashSet<String>());
            for(int j=1; j<arr.length; j++)
                map.get(name).add(arr[j]);
        }
        int q = in.nextInt(); in.nextLine();
        for(int i=0; i<q; i++) {
            String[] arr = in.nextLine().split(" ");
            Set<String> ans = new HashSet<String>(map.get(arr[0]));
            for(int j=1; j<arr.length; j++)
                ans.retainAll(map.get(arr[j]));
            if(ans.size() == 0) { System.out.println("No solution."); continue; }
            List<String> ans2 = new ArrayList<String>(ans);
            Collections.sort(ans2);
            for(int j=0; j<ans2.size(); j++)
                System.out.print(ans2.get(j)+(j==ans2.size()-1?"":" "));
            System.out.println();
        }
    }
}
