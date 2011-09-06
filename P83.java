import java.util.*;

public class P83 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextLine().length()-1;
        
        int ans = 1;
        for(int i=n; i>0; i-=k)
            ans*=i;
        System.out.println(ans);
    }
}
