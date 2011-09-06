import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P506 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int cnt = 0;
        int[][] grid = new int[(int)ceil(((double)n)/k)][k];
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[i].length; j++)
                grid[i][j]=-1;
        for(int c=0; c<k; c++)
            for(int r=0; cnt<n && r<grid.length; r++) {
                grid[r][c]=in.nextInt();
                cnt++;
            }
        for(int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[r].length; c++) {
                if(grid[r][c]!=-1)
                    System.out.printf("%4d",grid[r][c]);
            }
            System.out.println();
        }
    }
}
