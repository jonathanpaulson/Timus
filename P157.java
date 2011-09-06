import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P157 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int K = in.nextInt();
        for(int L=K; L<=10000; L++) {
            if(count(L-K)==M && count(L)==N) {
                System.out.println(L);
                return;
            }
        }
        System.out.println(0);
    }
    public static int count(int n) {
        int lim = (int)sqrt(n);
        int cnt = 0;
        for(int i=1; i<=lim; i++)
            if(n%i==0) cnt++;
        return cnt;
    }
}
