import java.util.*;

public class P290 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for(int i=0; i<n; i++)
            data[i] = in.nextInt();
        Arrays.sort(data);
        for(int i=data.length-1; i>=0; i--)
            System.out.println(data[i]);
    }
}
