import java.util.*;
import java.math.*;

public class P243 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = new BigInteger(in.nextLine());
        System.out.println(n.mod(new BigInteger("7")));
    }
}
