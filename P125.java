import java.util.*;
import java.awt.Point;
import java.math.*;

public class P125 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Integer> psq = new HashSet<Integer>();
        for(int i=0; i*i<=2*50*50; i++)
            psq.add(i*i);
        Set<Point> pts = new HashSet<Point>();
        for(int i=-50; i<=50; i++)
            for(int j=-50; j<=50; j++)
                if(psq.contains(i*i+j*j))
                    pts.add(new Point(i,j));
        int n = in.nextInt();
        int m = in.nextInt(); in.nextLine();
        boolean[][] grid = new boolean[n][m];
        for(int i=0; i<n; i++) {
            String line = in.nextLine();
            for(int j=0; j<m; j++)
                grid[i][j] = line.charAt(j) == 'B';
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(in.nextInt()%2 == 1) {
                    for(Point p:pts)
                        if(0<=i+p.x && i+p.x < n && 0<=j+p.y && j+p.y<m)
                            grid[i+p.x][j+p.y] = !grid[i+p.x][j+p.y];
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++)
                System.out.print(grid[i][j]?"B":"W");
            System.out.println();
        }
    }
}
