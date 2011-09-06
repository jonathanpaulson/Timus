import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P282 {
    static List<Integer>[] children;
    static int[] val;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        children = (List<Integer>[]) new List[N+1];
        for(int i=0; i<N+1; i++)
            children[i] = new ArrayList<Integer>();
        val = new int[N+1];
        for(int i=2; i<=N; i++) {
            if(in.next().equals("L")) {
                children[in.nextInt()].add(i);
                String value = in.next();
                if(value.equals("+1")) val[i] = 1;
                else val[i] = Integer.parseInt(value);
            }
            else children[in.nextInt()].add(i);
        }
        
        int score = calc(1,true);
        if(score == 1) System.out.println("+1");
        else System.out.println(score); 
    }
    public static int calc(int node,boolean first) {
        if(children[node].isEmpty()) return first?val[node]:-val[node];
        int best = -2;
        for(Integer i:children[node])
            best = max(best,-calc(i,!first));
        return best;
    }
}
