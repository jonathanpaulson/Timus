import java.util.*;
import java.awt.Point;
import java.math.*;

public class P121 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int w = in.nextInt();
        int[][] grid = new int[h][w];
        for(int i=0; i<h; i++)
            for(int j=0; j<w; j++)
                grid[i][j] = in.nextInt();
        
        List<Integer> seen = new ArrayList<Integer>();
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(grid[i][j] != 0) { System.out.print("-1"+(j==w-1?"":" ")); continue; }
                DIST: for(int dist=1; dist<=5; dist++) {
                    int sum = 0;
                    seen.clear();
                    for(int k=-dist; k<=dist; k++) {
                        for(int l=-dist; l<=dist; l++) {
                            if(0<=i+k && i+k<h && 0<=j+l && j+l<w && (Math.abs(k)+Math.abs(l))<=dist && !seen.contains(grid[i+k][j+l]))
                                { seen.add(grid[i+k][j+l]); sum|=grid[i+k][j+l]; }
                        }
                    }
                    //if(i==1 && j==1) System.out.println(i+" "+j+" "+dist+" "+sum);
                    if(sum > 0 || dist==5) { System.out.print(sum+(j==w-1?"":" ")); break DIST;}
                }
            }
            System.out.println();
        }
    }
}
