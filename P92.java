import java.util.*;
import java.awt.Point;
import java.math.*;

public class P92 {
    static int n;
    static boolean[][] grid;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); in.nextLine();
        grid = new boolean[2*n+1][2*n+1];
        for(int i=0; i<2*n+1; i++) {
            String line = in.nextLine();
            for(int j=0; j<2*n+1; j++)
                grid[i][j] = line.charAt(j)=='+';
        }

        System.out.println("There is solution:");
        for(int i=0; i<2*n; i++)
            for(int j=0; j<2*n; j++)
                if(grid[i][j])
                    flip(i,j,2*n,2*n);
        for(int i=0; i<2*n; i++) {
            int count = 0;
            if(grid[i][i]) count++;
            if(grid[i][2*n]) count++;
            if(grid[2*n][i]) count++;
            if(count>=2) flip(i,i,2*n,2*n);
        }
        if(!grid[2*n][2*n]) return;
        for(int i=0; i<2*n; i++)
            if(!grid[i][i] && !grid[i][2*n] && !grid[2*n][i]) return;
        for(int i=0; i<2*n; i++)
            if(!grid[i][i])
                flip(i,i,2*n,2*n);
        for(int i=0; i<2*n+1; i++)
            System.out.print((i+1)+(i==2*n?"":" "));
        System.out.println();
    }
    public static void flip(int y1,int x1, int y2,int x2) {
        Map<Integer,Integer> l = new HashMap<Integer,Integer>();
        for(int i=0, j=0; i<2*n+1; i++,j++) {
            while(i==y1 || i==y2) i++;
            while(j==x1 || j==x2) j++;
            l.put(i,j);
        }
        
        for(int iter=1; iter<=2; iter++) {
            for(int i=0; i<2*n+1; i++) {
                if(i!=y1 && i!=y2)
                    System.out.print( (l.get(i)+1) + (i==2*n?"":" "));
                else if(i==y1)
                    System.out.print( ((iter==1?x2:x1)+1) + (i==2*n?"":" "));
                else System.out.print( ((iter==1?x1:x2)+1) + (i==2*n?"":" "));
            
            }
            System.out.println();
        }
        grid[y1][x1] = !grid[y1][x1];
        grid[y1][x2] = !grid[y1][x2];
        grid[y2][x1] = !grid[y2][x1];
        grid[y2][x2] = !grid[y2][x2];
        //printGrid();
    }
    public static void printGrid() {
        for(int i=0; i<2*n+1; i++) {
            for(int j=0; j<2*n+1; j++)
                System.out.print(grid[i][j]?"+":"-");
            System.out.println();
        }
    }
}
