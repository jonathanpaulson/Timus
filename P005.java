import java.util.*;

public class P5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] w = new int[n];
        for(int i=0; i<n; i++)
            w[i] = in.nextInt();
        
        int best = Integer.MAX_VALUE;
        for(int i=0; i<Math.pow(2,n); i++) {
            int w1 = 0;
            int w2 = 0;
            for(int j=0; j<n; j++) {
                if( ((i>>j)&1) == 1)
                    w1+=w[j];
                else w2+=w[j];
            }
            if(Math.abs(w1-w2) < best)
                best = Math.abs(w1-w2);
        }
        System.out.println(best);
    }
}
