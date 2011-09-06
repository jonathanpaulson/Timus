import java.util.*;

public class P263 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] count = new int[n];
        for(int i=0; i<m; i++) {
            count[in.nextInt()-1]++;    
        }
        for(int i=0; i<n; i++) {
            System.out.printf("%.2f%%\n",100.0*count[i]/m);
        }
    }
}
