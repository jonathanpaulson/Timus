import java.util.*;
import java.math.*;

public class P352 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
                /*   0 1 2 3 4 5 6   7  8  9  10 11  12  13  14  15   16   17   18   19 */
        int[] exp = {0,2,3,5,7,13,17,19,31,61,89,107,127,521,607,1279,2203,2281,3217,4253,4423,9689,9941,11213,19937,21701,23209,44497,86243,110503,132049,216091,756839,859433,1257787,1398269,2976221,3021377,6972593};
        int n = in.nextInt();
        for(int i=0; i<n; i++) {
            System.out.println(exp[in.nextInt()]);
        }
    }
}
