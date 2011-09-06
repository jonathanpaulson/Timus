import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P425 {
    static int N;
    static int S;
    static HashSet<Long> set = new HashSet<Long>();
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        S = in.nextInt();
        if(N==1 && S==2) { System.out.println(1); return; }
        if(N <= 2) { System.out.println((long)pow(S,N)); return; }
        int[] C = new int[N];
        long pos = 0;
        for(int i=0; i<N; i++) {
            pos = pos*100+in.nextInt()-1;
        }
        bfs(pos);
        HashSet<Long> W = new HashSet<Long>(set);
        set.clear();
        for(Long L:W)
            bfs(L);
        System.out.println(set.size());
    }
    public static void bfs(long pos) {
       int[] C = toC(pos);
       for(int i=0; i<N; i++)
           for(int j=0; j<S; j++) {
               if(j==C[i]) continue;
               int tmp = C[i];
               C[i] = j;
               set.add(toL(C));
               C[i] = tmp;
           }

       for(int a=0; a<pow(2,N); a++) {
    OUTER: for(int j=1; j<S; j++) {
                int[] X = new int[N];
                for(int k=0; k<N; k++) {
                    int f = ((a>>k)&1) == 1 ? 1 : -1;
                    X[k] = C[k]+f*j;
                    if(X[k] >= S || X[k]<0) continue OUTER;
                }
                set.add(toL(X));
            }
       }
    }
    
    public static long toL(int[] C) {
        long ans = 0;
        for(int i=0; i<N; i++)
            ans = ans*100+C[i];
        return ans;
    }
    public static int[] toC(long L) {
        int[] C = new int[N];
        for(int i=N-1; i>=0; i--) {
            C[i] = (int)(L%100);
            L/=100;
        }
        return C;
    }
}
