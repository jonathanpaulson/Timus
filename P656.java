import java.util.*;
import java.awt.Point;
import java.math.*;

public class P656 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n*n];
        for(int i=0; i<n*n; i++)
            data[i] = in.nextInt();
        Arrays.sort(data);
        
        int[][] grid = new int[n][n];
        int index = n*n-1;
        int mid = n/2;
        for(int dist=0; dist<n; dist++) {
            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++)
                    if(Math.abs(i-n/2)+Math.abs(j-n/2) == dist)
                        grid[i][j] = data[index--];
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++)
                System.out.print(grid[i][j]+(j==n-1?"":" "));
            System.out.println();
        }
    }
}
