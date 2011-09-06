import java.util.*;
import java.awt.Point;
import java.math.*;

public class P601 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String q = "";
        while(in.hasNextLine())
            q+=in.nextLine()+"\n";
        boolean flag = true;
        for(int i=0; i<q.length(); i++) {
            char c = q.charAt(i);
            if(c=='.' || c=='?' || c=='!')
                flag = true;
            if(Character.isLetter(c)) {
                if(flag) flag = false;
                else c = Character.toLowerCase(c);
            }
            System.out.print(c);
        }
    }
}
