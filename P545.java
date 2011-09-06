import java.util.*;
import java.awt.Point;
import java.math.*;

public class P545 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        Set<String>[] sets = (HashSet<String>[]) new HashSet[26];
        for(int i=0; i<26; i++)
            sets[i] = new HashSet<String>();
        for(int i=0; i<n; i++) {
            String line = in.nextLine();
            sets[line.charAt(0)-'a'].add(line);
        }
        String req = in.nextLine();
        for(String s:sets[req.charAt(0)-'a'])
            System.out.println(s);
    }
}
