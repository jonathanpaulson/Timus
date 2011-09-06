import java.util.*;
import java.awt.Point;
import java.math.*;

public class P80 {
    static int[] color;
    static boolean[][] edges;
    static boolean bad = false;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        edges = new boolean[n][n];
        for(int i=0; i<n; i++) {
            int num = 1;
            while(num != 0) {
                num = in.nextInt();
                if(num==0) break;
                edges[i][num-1] = true;
                edges[num-1][i] = true;
            }
        }
        color = new int[n];
        for(int i=0; i<n; i++) {
            if(color[i]==0) { color[i]=1; dfs(i); }
        }
        if(bad) { System.out.println("-1"); System.exit(0); }
        for(int i=0; i<n; i++)
            System.out.print(color[i]==1?"0":"1");
        System.out.println();
    }
    public static void dfs(int n) {
        for(int i=0; i<color.length; i++)
            if(edges[n][i]) {
                if(color[i]==0) {
                    color[i] = color[n]==1?-1:1; dfs(i);
                }
                if(color[i]==color[n]) bad = true;
            }
    }
}
