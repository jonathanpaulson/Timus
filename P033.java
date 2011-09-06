import java.util.*;

public class P33 {
    static int n;
    static boolean[][] wall;
    static  boolean[][] can;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); in.nextLine();
        wall = new boolean[n][n];
        can = new boolean[n][n];

        for(int i=0; i<n; i++) {
            String line = in.nextLine();
            for(int j=0; j<n; j++)
                wall[i][j] = line.charAt(j)=='#';
        }
        fill(0,0);
        fill(n-1,n-1);

        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(can[i][j]) {
                    if((i==0) || wall[i-1][j]) ans++;
                    if((i==n-1) || wall[i+1][j]) ans++;
                    if((j==0) || wall[i][j-1]) ans++;
                    if((j==n-1) || wall[i][j+1]) ans++;
                }
            }
        }
        System.out.println((ans-4)*9);
    }
    public static void fill(int i,int j) {
        can[i][j] = true;
        if(i>0 && !wall[i-1][j] && !can[i-1][j]) fill(i-1,j);
        if(j>0 && !wall[i][j-1] && !can[i][j-1]) fill(i,j-1);
        if(i<n-1 && !wall[i+1][j] && !can[i+1][j]) fill(i+1,j);
        if(j<n-1 && !wall[i][j+1] && !can[i][j+1]) fill(i,j+1);
    }
}
