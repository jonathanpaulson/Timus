import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P571 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        List<String> langs = new ArrayList<String>();
        boolean has_dups = false;
        for(int i=0; i<n; i++) {
            String next = in.nextLine();
            if(langs.contains(next)) has_dups = true;
            langs.add(next);
        }
        String mine = "";
OUTER: for(char c1='a'; c1<='z'; c1++)
            for(char c2='a'; c2<='z'; c2++)
                if(!langs.contains(c1+""+c2)) {
                    mine = c1+""+c2;
                    break OUTER;
                }
        
        if(n==1) { System.out.println(0); return; }
        if(n==2) { 
            if(has_dups) { System.out.println(0); return; }
            System.out.printf("1\n%s-%s\n",langs.get(0),langs.get(1));
            return;
        }
        if(has_dups) { System.out.println("Impossible"); return; }
        System.out.println(n);
        for(int i=0; i<n; i++)
            System.out.printf("%s-%s\n",langs.get(i),mine);
    }
}
