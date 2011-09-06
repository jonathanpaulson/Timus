import java.util.*;
import java.awt.Point;
import java.math.*;

public class P220 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        Stack<Integer>[] stacks = (Stack<Integer>[]) new Stack[1000];
        for(int i=0; i<1000; i++)
            stacks[i] = new Stack();
        for(int i=0; i<n; i++) {
            String[] arr = in.nextLine().split(" ");
            if(arr[0].equals("PUSH"))
                stacks[Integer.parseInt(arr[1])-1].push(Integer.parseInt(arr[2]));
            else System.out.println(stacks[Integer.parseInt(arr[1])-1].pop());
        }
    }
}
