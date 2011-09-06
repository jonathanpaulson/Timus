import java.util.*;
import java.awt.Point;
import java.math.*;

public class P617 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<n; i++) {
            int num = in.nextInt();
            if(!map.containsKey(num)) map.put(num,1);   
            else map.put(num,map.get(num)+1);
        }
        int ans = 0;
        for(Integer val:map.values())
            ans+=val/4;
        System.out.println(ans);
    }
}
