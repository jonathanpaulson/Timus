import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P723 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int[] freq = new int[256];
        for(int i=0; i<s.length(); i++)
            freq[s.charAt(i)]++;
        int max = 0;
        for(int i=1; i<256; i++)
            if(freq[i]>freq[max])
                max = i;
        System.out.println( (char)max );
    }
}
