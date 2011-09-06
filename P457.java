import java.util.*;

public class P457 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        for(int i=0; i<n; i++)
            sum+=in.nextInt();
        System.out.printf("%.6f\n",((double)sum)/n);
    }
}
