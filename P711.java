import java.util.*;
import java.util.regex.*;
import java.awt.Point;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;

public class P711 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[][] arr = new String[n][3];
        for(int i=0; i<n; i++)
            for(int j=0; j<3; j++)
                arr[i][j] = in.next();
        List<String> ans = new ArrayList<String>();
        String to_beat = null;
        for(int i=0; i<n; i++) {
            int ix = in.nextInt()-1;
            String cand = null;
            for(int j=0; j<3; j++)
                if( (cand == null || cand.compareTo(arr[ix][j]) > 0) && (to_beat == null || arr[ix][j].compareTo(to_beat)>0)) {
                    cand = arr[ix][j];
                }
            if(cand == null) { System.out.println("IMPOSSIBLE"); return; }
            ans.add(cand);
            to_beat = cand;
        }

        for(String s:ans)
            System.out.println(s);
    }
}
