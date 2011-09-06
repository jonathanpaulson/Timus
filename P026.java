import java.util.*;

public class P26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        int[] data = new int[n];
        for(int i=0; i<n; i++)
            { data[i] = in.nextInt(); in.nextLine(); }
        Arrays.sort(data);
        in.nextLine();
        int k = in.nextInt();
        for(int i=0; i<k; i++) {
            System.out.println(data[in.nextInt()-1]);
        }
    }
}
