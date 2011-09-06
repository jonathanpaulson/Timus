import java.util.*;
import java.awt.Point;
import java.math.*;

public class P49 {
    static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int i=0; i<10; i++)
            factors(in.nextInt());
        long ans = 1;
        for(Integer key:map.keySet())
            ans = ans*(map.get(key)+1)%10;
        System.out.println(ans%10);
    }
    public static void factors(int n) {
        if(n==1) return;
        for(int i=2; i<=Math.sqrt(n); i++)
            if(n%i==0 && prime(i))
                { add(i); factors(n/i); return; }
        add(n);
        
    }
    public static void add(int k) {
        if(map.containsKey(k))
            map.put(k,map.get(k)+1);
        else map.put(k,1);
    }   
    public static boolean prime(int n) {
        for(int i=2; i<=Math.sqrt(n); i++)
            if(n%i==0) return false;
        return true;
    }
}
