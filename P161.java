import java.util.*;

public class P161 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for(int i=0; i<n; i++)
            data[i] = in.nextInt();
        Arrays.sort(data);
        double acc = data[data.length-1];
        for(int i=data.length-2; i>=0; i--)  {
            acc = 2*Math.sqrt(acc*data[i]);
        }
        System.out.printf("%.2f\n",acc);
    }
}
