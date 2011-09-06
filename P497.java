import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P497 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        boolean[][] grid = new boolean[n][n];
        for(int i=0; i<n; i++) {
            String s = in.nextLine();
            for(int j=0; j<n; j++) 
                grid[i][j] = s.charAt(j)=='1';
        }

        boolean left_ok = true;
LEFT: for(int i=1; i<n; i++)
          for(int j=0; j<n; j++)
              if(grid[i][j] && !grid[i-1][j]) {
                  left_ok = false;
                  break LEFT;
              }
        boolean right_ok = true;
RIGHT: for(int i=0; i<n-1; i++)
          for(int j=0; j<n; j++)
              if(grid[i][j] && !grid[i+1][j]) {
                  right_ok = false;
                  break RIGHT;
              }
        boolean down_ok = true;
DOWN: for(int i=0; i<n; i++)
          for(int j=0; j<n-1; j++)
              if(grid[i][j] && !grid[i][j+1]) {
                  down_ok = false;
                  break DOWN;
              }
        boolean up_ok = true;
UP: for(int i=0; i<n; i++)
          for(int j=1; j<n; j++)
              if(grid[i][j] && !grid[i][j-1]) {
                  up_ok = false;
                  break UP;
              }

        System.out.println(left_ok || right_ok || down_ok || up_ok ? "Yes" : "No");
    }
}
