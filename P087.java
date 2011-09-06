import java.util.*;

public class P87 {
    static int k;
    static int[] w;
    static int[] cache;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        cache = new int[n+1];
        for(int i=0; i<=n; i++) cache[i] = -1;
        k = in.nextInt();
        w = new int[k];
        for(int i=0; i<k; i++)
            w[i] = in.nextInt();

        for(int i=0; i<n; i++)
            win(i);
        System.out.println(win(n)?"1":"2"); 
    }
    public static boolean win(int n) {
        if(n==0) return true;
        if(n<0) return true;
        if(cache[n]>=0) return cache[n]==1;
    
        for(int i=0; i<k; i++)
            if(!win(n-w[i]))
                { cache[n]=1; return true;}
        cache[n]=0;
        return false;
    }
}
