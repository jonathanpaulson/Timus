import java.util.*;
import java.awt.Point;
import java.math.*;

public class P123 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String orig = in.nextLine();
        StringBuffer line = new StringBuffer(orig);
        int start = line.length()/2+(line.length()%2==1?1:0);
        for(int i=0; line.length()-1-i>i; i++) {
            line.setCharAt(line.length()-1-i,line.charAt(i));
        }   
        if(line.toString().compareTo(orig)<0) {
            int ind = line.length()/2;
            while(line.charAt(ind) == '9') {
                line.setCharAt(ind,'0');
                line.setCharAt(line.length()-1-ind,'0');
                ind++;
            }
            line.setCharAt(ind,(char)(line.charAt(ind)+1));
            if(line.length()-1-ind != ind) line.setCharAt(line.length()-1-ind,(char)(line.charAt(line.length()-1-ind)+1));
        }
        System.out.println(line.toString());
    }
}
