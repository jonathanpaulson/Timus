import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P54 {
    static int[] T;
    static int[] D;
    static int cnt = 0;
    static boolean finished = false;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        T = new int[n];
        boolean done=true;
        for(int i=0; i<n; i++) {
            T[i] = in.nextInt()-1;
            if(T[i]>0) done=false;
        }
        if(done) { System.out.println(0); return; }
        D = new int[n];
        hanoi(n,0,1,2);
        if(!finished) System.out.println(-1);
    }
    public static void hanoi(int k,int from,int to,int tmp) {
        if(k>1) hanoi(k-1,from,tmp,to);
        D[k-1]=to;
        cnt++;
        boolean done = true;
        for(int i=0; i<T.length; i++)
            if(D[i]!=T[i]) done=false;
        //System.out.println(Arrays.toString(D));
        if(done) { System.out.println(cnt); finished=true; }
        if(k>1) hanoi(k-1,tmp,to,from);
    }
}
