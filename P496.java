import java.util.*;

public class P496 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        Set<String> seen = new HashSet<String>();
        Set<String> done = new HashSet<String>();
        for(int i=0; i<n; i++) {
            String line = in.nextLine();
            if(seen.contains(line) && !done.contains(line)) {
                System.out.println(line);
                done.add(line);
            }
            seen.add(line);
        }
    }
}
