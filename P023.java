import java.util.*;
import java.awt.Point;
import java.math.*;

public class P23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        for(int L=2; L<=k; L++)
            if(k%(L+1)==0)
                { System.out.println(L); System.exit(0); }
    }
}
