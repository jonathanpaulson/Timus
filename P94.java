import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P94 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] out = new char[80];
        for(int i=0; i<80; i++)
            out[i]=' ';
        int cursor = 0;
        while(in.hasNextLine()) {
            String s = in.nextLine();
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i)=='<') {
                    cursor--;
                    if(cursor==-1) cursor=0;
                }
                else { 
                    if(s.charAt(i)!='>') out[cursor]=s.charAt(i);
                    cursor++;
                    if(cursor==80) cursor=0;
                }
            }
        }
        System.out.println(new String(out));
    }
}
