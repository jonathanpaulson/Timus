import java.util.*;

public class P404 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int n = line.length();
        int[] data = new int[n];
        for(int i=0; i<n; i++)
            data[i] = line.charAt(i)-'a';
        for(int i=n-1; i>=1; i--)
            data[i] = (data[i]+26-data[i-1])%26;
        data[0] = (data[0]+26-5)%26;
        for(int i=0; i<data.length; i++)
            System.out.print( (char)(data[i]+'a') );
        System.out.println();
    }
}
