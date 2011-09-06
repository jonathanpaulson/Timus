import java.util.*;

public class P21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int an = in.nextInt();
        int[] a = new int[an];
        for(int i=0; i<an; i++)
            a[i] = in.nextInt();
        int bn = in.nextInt();
        int[] b = new int[bn];
        for(int i=0; i<bn; i++)
            b[i] = in.nextInt();

        int ai=0,bi=0;
        while(ai<an && bi<bn && a[ai]+b[bi]!=10000) {
            if(a[ai]+b[bi]<10000) ai++;
            else bi++;
        }
        if(ai==an || bi==bn) System.out.println("NO");
        else System.out.println("YES");
    }
}
