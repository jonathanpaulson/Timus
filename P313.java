import java.util.*;

public class P313 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] grid = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                grid[i][j] = in.nextInt();
        for(int diag = 0; diag<2*n; diag++) {
            for(int x=n-1; x>=0; x--) {
                if(0<=diag-x && diag-x<n)
                    System.out.print(grid[x][diag-x]+(diag!=2*n-1?" ":""));
            }
        }
    }
}
