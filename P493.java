import java.util.*;

public class P493 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(lucky(n-1)||lucky(n+1)?"Yes":"No");
    }
    public static boolean lucky(int n) {
        int s1 = 0, s2 = 0;
        for(int i=0; i<3; i++) {
            s1+=n%10;
            n/=10;
        }
        while(n>=1000) n/=10;
        for(int i=0; i<3; i++) {
           s2+=n%10;
            n/=10; 
        }
        return s1==s2;
    }
}
