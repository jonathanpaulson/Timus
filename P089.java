import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P89 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> dict = new ArrayList<String>();
        while(true) {
            String s = in.nextLine();
            if(s.equals("#")) break;
            dict.add(s);
        }

        int ans = 0;
        while(in.hasNextLine()) {
            StringBuffer text = new StringBuffer(in.nextLine());
            int start = 0;
            int end = 0;
            while(end<text.length()) {
                while(end<text.length() && Character.isLetter(text.charAt(end)))
                    end++;
                for(String s:dict) {
                    int cnt = 0;
                    if(s.length()!=end-start) continue;
                    for(int i=0; i<s.length(); i++)
                        if(s.charAt(i)!=text.charAt(start+i))
                            cnt++;
                    if(cnt>=2 || cnt==0) continue;
                    ans++;
                    for(int i=0; i<s.length(); i++)
                        if(s.charAt(i)!=text.charAt(start+i))
                            text.setCharAt(start+i,s.charAt(i));
                }
                start = end+1;
                end = end+1;
            }
            System.out.println(text);
        }
        System.out.println(ans);
    }
}
