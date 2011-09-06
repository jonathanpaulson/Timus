import java.util.*;
import java.awt.Point;
import java.math.*;
import java.io.*;

public class P413 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();

        double len = 1/Math.sqrt(2);
        int[] counts = new int[10];
        for(int i=0; i<line.length(); i++) {
            if(line.charAt(i) == '0')
                break;
            counts[line.charAt(i)-'0']++;
        }
        double x=len*(counts[3]+counts[9]-counts[1]-counts[7])+counts[6]-counts[4];
        double y=len*(counts[7]+counts[9]-counts[1]-counts[3])+counts[8]-counts[2];
        System.out.printf("%.10f %.10f\n",x,y);
    }
}
