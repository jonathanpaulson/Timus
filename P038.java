import java.util.*;
import java.awt.Point;
import java.math.*;
import static java.lang.Math.*;

public class P38 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = "";
        while(in.hasNextLine()) { 
            s+=in.nextLine()+" ";
        }
        boolean start = true;
        int cnt = 0;
        for(int i=0; i<s.length(); i++) {
            if(start && Character.isLetter(s.charAt(i)) && Character.isLowerCase(s.charAt(i))) cnt++;
            if(Character.isUpperCase(s.charAt(i)) && i>0 && Character.isLetter(s.charAt(i-1))) cnt++;
            if(Character.isLetter(s.charAt(i))) start = false;
            if(s.charAt(i)=='.' || s.charAt(i)=='!' || s.charAt(i)=='?')
                start = true;
        }
        System.out.println(cnt);
    }
}
