import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P122 {
    static boolean[][] move = new boolean[3][3];
    static boolean[][] grid2 = new boolean[4][4];
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int grid = 0;
        for(int i=0; i<4; i++) {
            String s = in.next();
            for(int j=0; j<4; j++)
                grid |= (1<<(i*4+j))*(s.charAt(j)=='B'?1:0);
        }
        for(int i=0; i<3; i++) {
            String s = in.next();
            for(int j=0; j<3; j++)
                move[i][j] = s.charAt(j)=='1';
        }

        Queue<Integer> Q = new LinkedList<Integer>();
        Q.offer(grid);
        boolean[] seen = new boolean[1<<16];
        int[] d = new int[1<<16];
        while(!Q.isEmpty()) {
            Integer g = Q.poll();
            if(seen[g]) continue;
            seen[g]=true;
            de_hash(g);
            if(g==0 || g==((1<<16)-1)) { System.out.println(d[g]); return; }
            
            for(int i=0; i<4; i++)
                for(int j=0; j<4; j++) {
                    for(int k=-1; k<=1; k++)
                        for(int l=-1; l<=1; l++)
                            if(i+k>=0 && i+k<4 && j+l>=0 && j+l<4 && move[k+1][l+1])
                                grid2[i+k][j+l]=!grid2[i+k][j+l];
                    int next = hash(grid2);
                    d[next]=d[g]+1;
                    if(!seen[next]) Q.offer(next);
                    for(int k=-1; k<=1; k++)
                        for(int l=-1; l<=1; l++)
                            if(i+k>=0 && i+k<4 && j+l>=0 && j+l<4 && move[k+1][l+1])
                                grid2[i+k][j+l]=!grid2[i+k][j+l];
                }
        }
       System.out.println("Impossible");
    }
    public static int hash(boolean[][] grid) {
        int ans = 0;
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[i].length; j++)
                ans |= (1<<(4*i+j))*(grid[i][j]?1:0);
        return ans;
    }
    public static void de_hash(int grid) {
        for(int i=0; i<4; i++)
            for(int j=0; j<4; j++) {
                grid2[i][j]=false;
                if( ((grid>>(4*i+j))&1)==1 )
                    grid2[i][j]=true;
            }
    }
    public static void print(boolean[][] grid) {
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++)
                System.out.print(grid[i][j]?"1":"0");
            System.out.println();
        }
    }
}
