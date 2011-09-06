import java.util.*;

public class P193 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] std = new int[n][3];
        for(int i=0; i<n; i++)
            for(int j=0; j<3; j++)
                std[i][j] = in.nextInt();
        Arrays.sort(std,new Comparator<int[]>() {
            public int compare(int[] a,int[] b) { return a[0]-b[0]; }
        });
        int max = 0;
        boolean[] busy = new boolean[10000];
        int start = 0;
        for(int i=0; i<n; i++) {
            start = Math.max(start, std[i][0]);
            max = Math.max(max,start+std[i][1]-std[i][2]);
            start += std[i][1];
        }
        System.out.println(max);
    }
}
