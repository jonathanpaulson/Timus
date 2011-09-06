import java.util.*;

public class P14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n==0) { System.out.println(10); System.exit(0); }
        if(n==1) { System.out.println(1); System.exit(0); }
        int[] count = new int[10];
        for(int i=9; i>=2; i--) {
            while(n%i==0) {
                n/=i;
                count[i]++;
            }
        }
        if(n>1) { System.out.println(-1); System.exit(0); }
        for(int i=2; i<=9; i++)
            for(int j=0; j<count[i]; j++)
                System.out.print(i);
        System.out.println();
    }
}
