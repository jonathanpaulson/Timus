import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P297 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        int max_l = 0;
        int max_i = 0;
        boolean odd = true;
        for(int i=0; i<s.length(); i++) {
            int l = 0;
            while(i+l<s.length() && i-l>=0 && s.charAt(i+l)==s.charAt(i-l)) l++;
            if(l>max_l) { max_l=l; max_i=i; odd=true; }
            l--;
        
            l=0;
            while(i+1+l<s.length() && i-l>=0 && s.charAt(i+1+l)==s.charAt(i-l)) l++;
            if(l>max_l || (l==max_l && odd)) { max_l=l; max_i=i; odd=false; }
            l--;
        }
        if(odd) { System.out.println(s.substring(max_i-max_l+1,max_i+max_l)); }
        else { System.out.println(s.substring(max_i-max_l+1,max_i+max_l+1)); }
    }
}
