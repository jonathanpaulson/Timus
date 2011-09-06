import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P712 {
    public static void main(String[] args) throws Exception {
        boolean[][] grid = new boolean[4][4];
        char[][] chars = new char[4][4];
        Scanner in = new Scanner(System.in);
        for(int i=0; i<4; i++) {
            String s = in.nextLine();
           for(int j=0; j<4; j++) grid[i][j] = s.charAt(j)=='X'; 
        }
        for(int i=0; i<4; i++) {
            String s = in.nextLine();
           for(int j=0; j<4; j++) chars[i][j] = s.charAt(j); 
        }

        String ans = "";
        for(int i=0; i<4; i++) {
            grid = rot(grid);
            for(int x=3; x>=0; x--) {
                for(int y=3; y>=0; y--) {
                    if(grid[x][y]) ans = chars[x][y]+ans;
                }
            }
        }
        System.out.println(ans);
    }
    public static boolean[][] rot(boolean[][] grid) {
        boolean[][] ans = new boolean[4][4];
        for(int x=0; x<=3; x++)
            for(int y=0; y<=3; y++)
                ans[x][y] = grid[y][3-x];
        return ans;
    }
}
