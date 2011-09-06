import java.util.*;
import java.awt.Point;
import java.math.*;

public class P567 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        long cost = 0;
        for(int i=0; i<line.length(); i++)
            cost += cost(line.charAt(i));
        System.out.println(cost);
    }
    public static int cost(char c) {
        if(Character.isLetter(c))
            return (c-'a')%3+1;
        if(c==' ') return 1;
        if(c=='.') return 1;
        if(c==',') return 2;
        if(c=='!') return 3;
        return -5000;
    }
}
