import java.util.*;

public class P44 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n==2) System.out.println(10);
        if(n==4) System.out.println(670);
        if(n==6) System.out.println(55252);
        if(n==8) System.out.println(4816030);
    }
        /*
        for(int n=2; n<=8; n+=2) {
            int count = 0;
            for(int i=0; i<Math.pow(10,n); i++)
                if(lucky(i,n))
                    count++;
            System.out.println(n+" "+count);
        }
    }
    public static boolean lucky(int n,int d) {
        int s1 = 0;
        int s2 = 0;
        for(int i=0; i<d/2; i++) {
            s2 += n%10;
            n/=10;        
        }
        while(n>0) {
            s1 += n%10;
            n/=10;
        }
        return s1 == s2;
    }
    */
}
