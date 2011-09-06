import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P494 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Stack<Integer> S = new Stack<Integer>();
        int seen = 0;
        for(int i=0; i<n; i++) {
            int x = in.nextInt();
            if(x < seen) {
                if(x != S.peek()) { System.out.println("Cheater"); return; }
                else S.pop();
            }
            else {
                for(int j = seen+1; j < x; j++)
                    S.push(j);
                seen = x;
            }
        }
        System.out.println("Not a proof");
    }
}
