import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P727 {
    public static void main(String[] args) {
        int L = 100000;
        Scanner in = new Scanner(System.in);
        LinkedList<Integer>[] vals = (LinkedList<Integer>[]) new LinkedList[9*6];
        for(int i=0; i<vals.length; i++)
            vals[i] = new LinkedList<Integer>();
        for(int i=0; i<L; i++) {
            vals[f(i)].addFirst(i);
        }
        int n = in.nextInt();
        int d=9*5;
        List<Integer> used = new ArrayList<Integer>();
        while(n>0) {
            if(n>=d && !vals[d].isEmpty()) {
                n-=d;
                used.add(vals[d].getFirst());
                vals[d].removeFirst();
                
            } else d--;
        }
        System.out.println(used.size());
        for(int i=0; i<used.size(); i++) {
            System.out.print(used.get(i)+(i==used.size()-1?"":" "));
        }
        System.out.println();
    }
    public static int f(int n) {
        int ans = 0;
        while(n > 0) {
            ans+=n%10;
            n/=10;
        }
        return ans; 
    }
}
