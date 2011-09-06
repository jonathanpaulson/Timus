import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P612 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer str = new StringBuffer();
		while(true) {
			String s = in.readLine();
			if(s==null) break;
			str.append(s+"\n");
		}
		String[] words = str.toString().split("[^a-z]");
		int tram_cnt = 0;
		int trolley_cnt = 0;
		for(String s:words) {
			if(s.equals("tram")) tram_cnt++;
			if(s.equals("trolleybus")) trolley_cnt++;
		}
		if(tram_cnt>trolley_cnt) System.out.println("Tram driver");
		else if(tram_cnt<trolley_cnt) System.out.println("Trolleybus driver");
		else System.out.println("Bus driver");
    }
}
