import java.util.*;
import java.math.*;

public class P9 { //Also P12,P13
    static BigInteger[][] solve;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        solve = new BigInteger[n+1][k+1];
        for(int i=0; i<=n; i++)
            for(int j=0; j<=k; j++)
                solve[i][j] = new BigInteger( (-1)+"");
        System.out.println(new BigInteger((k-1)+"").multiply(solve(n-1,k)));
    }
    public static BigInteger solve(int n,int k) {
        if(n==0) return new BigInteger(1+"");
        if(n==1) return new BigInteger(k+"");
        if(solve[n][k] .equals( new BigInteger((-1)+"")))
            solve[n][k] = new BigInteger((k-1)+"").multiply( solve(n-2,k).add(solve(n-1,k)));
        return solve[n][k];
    }
}
