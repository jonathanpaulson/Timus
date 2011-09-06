import java.util.*;
import java.awt.Point;
import java.math.*;

public class P190 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for(int i=0; i<n; i++) data[i]=-1;
        for(int i=0; i<n; i++) {
            in.next();
            if(in.nextInt()==1) {
                data[i] = in.nextInt();
            }
        }
        int max = 10000;
        int max_sum = 0;
        int min_sum = 0;
        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(data[i]==-1) { max_sum+=max; cnt++; }
            else {
                max=data[i];
                max_sum+=data[i];
                min_sum+=(cnt+1)*data[i];
                cnt=0;
            }
        }
        min_sum+=cnt;
        //System.out.println(min_sum+" "+max_sum);
        if(min_sum <= 100*100 && max_sum >= 100*100)
            System.out.println("YES");
        else System.out.println("NO");
    }
}
