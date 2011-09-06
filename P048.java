import java.util.*;
import java.io.*;
import java.math.*;

public class P48 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int)in.nval;
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            in.nextToken(); int a =(int)in.nval;
            in.nextToken(); int b =(int)in.nval;
            ans[i] = (a+b)%10;
            if(a+b>=10) {
                int j=i-1;
                while(ans[j]==9) { ans[j]=0; j--;}
                ans[j]++;
            }
        }
        for(int i=0; i<n; i++)
            System.out.print(ans[i]);
        System.out.println();
    }
}
