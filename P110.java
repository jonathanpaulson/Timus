import java.util.*;
import java.math.*;

public class P110 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = new BigInteger(""+in.nextInt());
        int m = in.nextInt();
        BigInteger bm = new BigInteger(m+"");
        BigInteger y = new BigInteger(""+in.nextInt());
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0; i<m; i++)
            if(new BigInteger(i+"").modPow(n,bm).equals(y))
                ans.add(i);
        if(ans.size()==0)
            System.out.println(-1);
        for(int i=0; i<ans.size(); i++)
            System.out.print(ans.get(i)+(i==ans.size()-1?"":" "));
        System.out.println();
    }
}
