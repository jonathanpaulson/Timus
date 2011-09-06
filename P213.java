import java.util.*;
import java.awt.Point;
import java.math.*;

public class P213 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        Set<String> set = new HashSet<String>();
        while(in.hasNextLine()) {
            String[] arr = in.nextLine().split("-");
            if(arr[0].equals("#")) break;
            set.add(arr[0]);
            set.add(arr[1]);
        }
        System.out.println(set.size()==0 ? 0 : set.size()-1);
    }
}
