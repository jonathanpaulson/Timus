import java.util.*;

public class P319 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] grid = new int[n][n];
        int cur=1;
        for(int diag=n; diag>=-n; diag--) {
            for(int x=0; x<n; x++) {
                if(0<=x+diag && x+diag<n)
                    grid[x][x+diag] = cur++;
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++)
                System.out.print(grid[i][j]+(j==n-1?"":" "));
            System.out.println();
        }
    }
}
