import java.util.*;

public class P283 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int P = in.nextInt();
        int E = in.nextInt();
        double r = (100-in.nextInt())/100.0;
        int i;
        for(i=0; P*Math.pow(r,i)>E; i++);
        System.out.println(i);
    }
}
