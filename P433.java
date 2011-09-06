import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P433 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s1 = in.next().toCharArray();
        char[] s2 = in.next().toCharArray();
        Arrays.sort(s1); Arrays.sort(s2);
        System.out.println(new String(s1).equals(new String(s2))?"equal":"different");
    }
}
