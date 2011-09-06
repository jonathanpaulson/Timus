import java.util.*;
import java.io.*;

public class P196 {
    static BufferedReader in;
    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));
        int n = nextInt();
        Set<Integer> a = new HashSet<Integer>();
        for(int i=0; i<n; i++)
            a.add(nextInt());
        int k = nextInt();
        int score = 0;
        for(int i=0; i<k; i++)
            if(a.contains(nextInt()))
                score++;
        System.out.println(score);
    }
    public static int nextInt() throws Exception { return Integer.parseInt(in.readLine()); }
}
