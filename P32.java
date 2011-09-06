import java.util.*;
import java.awt.Point;
import java.math.*;

public class P32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        int[] sum = new int[n];
        data[0] = in.nextInt();
        sum[0] = data[0];
        for(int i=1; i<n; i++) {
            data[i] = in.nextInt();
            sum[i] = data[i]+sum[i-1];
            
        }
        
        int[] mod = new int[n];
        for(int i=0; i<n; i++) mod[i] = -1;
        for(int i=0; i<n; i++) {
            if(sum[i] % n == 0) {
                System.out.println(i+1);
                for(int j=0; j<=i; j++)
                    System.out.println(data[j]);
                break;
            }
            if(mod[sum[i]%n] == -1) {
                mod[sum[i]%n] = i;
            }
            else {
                System.out.println(i-mod[sum[i]%n]);
                for(int j=mod[sum[i]%n]+1; j<=i; j++)
                    System.out.println(data[j]);
                break;
            }
        }
    }
}
