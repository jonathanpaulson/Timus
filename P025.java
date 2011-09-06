import java.util.*;

public class P25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int[] w = new int[k];
        for(int i=0; i<k; i++)
            w[i] = in.nextInt();

        int ans = 0;
        Arrays.sort(w);
        for(int i=0; i<(k+1)/2; i++)
            ans += (w[i]+1)/2;
        System.out.println(ans);
    }
}
